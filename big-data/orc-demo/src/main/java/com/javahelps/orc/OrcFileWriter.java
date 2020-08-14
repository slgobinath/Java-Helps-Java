package com.javahelps.orc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.common.type.HiveDecimal;
import org.apache.hadoop.hive.ql.exec.vector.*;
import org.apache.orc.OrcFile;
import org.apache.orc.TypeDescription;
import org.apache.orc.Writer;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class OrcFileWriter {
    public static void main(String[] args) throws IOException {
        List<Map<String, Object>> data = new LinkedList<>();
        data.add(Map.of("order_id", 1, "item_name", "Laptop", "price", 800.0f));
        data.add(Map.of("order_id", 2, "item_name", "Mouse", "price", 150.0f));
        data.add(Map.of("order_id", 3, "item_name", "Keyboard", "price", 250.0f));

        write(new Configuration(), "orders.orc", "struct<order_id:int,item_name:string,price:float>", data);

        System.out.println("Done");
    }

    public static void write(Configuration configuration, String path, String struct, List<Map<String, Object>> data) throws IOException {
        // Create the schemas and extract metadata from the schema
        TypeDescription schema = TypeDescription.fromString(struct);
        List<String> fieldNames = schema.getFieldNames();
        List<TypeDescription> columnTypes = schema.getChildren();

        // Create a row batch
        VectorizedRowBatch batch = schema.createRowBatch();

        // Get the column vector references
        List<BiConsumer<Integer, Object>> consumers = new ArrayList<>(columnTypes.size());
        for (int i = 0; i < columnTypes.size(); i++) {
            TypeDescription type = columnTypes.get(i);
            ColumnVector vector = batch.cols[i];
            consumers.add(createColumnWriter(type, vector));
        }

        // Open a writer to write the data to an ORC fle
        try (Writer writer = OrcFile.createWriter(new Path(path),
                OrcFile.writerOptions(configuration)
                        .setSchema(schema))) {
            for (Map<String, Object> row : data) {
                // batch.size should be increased externally
                int rowNum = batch.size++;

                // Write each column to the associated column vector
                for (int i = 0; i < fieldNames.size(); i++) {
                    consumers.get(i).accept(rowNum, row.get(fieldNames.get(i)));
                }

                // If the buffer is full, write it to disk
                if (batch.size == batch.getMaxSize()) {
                    writer.addRowBatch(batch);
                    batch.reset();
                }
            }

            // Check unwritten rows before closing
            if (batch.size != 0) {
                writer.addRowBatch(batch);
            }
        }
    }

    public static BiConsumer<Integer, Object> createColumnWriter(TypeDescription description, ColumnVector columnVector) {
        String type = description.getCategory().getName();
        BiConsumer<Integer, Object> consumer;
        if ("tinyint".equals(type)) {
            consumer = (row, val) -> ((LongColumnVector) columnVector).vector[row] = ((Number) val).longValue();
        } else if ("smallint".equals(type)) {
            consumer = (row, val) -> ((LongColumnVector) columnVector).vector[row] = ((Number) val).longValue();
        } else if ("int".equals(type) || "date".equals(type)) {
            // Date is represented as int epoch days
            consumer = (row, val) -> ((LongColumnVector) columnVector).vector[row] = ((Number) val).longValue();
        } else if ("bigint".equals(type)) {
            consumer = (row, val) -> ((LongColumnVector) columnVector).vector[row] = ((Number) val).longValue();
        } else if ("boolean".equals(type)) {
            consumer = (row, val) -> ((LongColumnVector) columnVector).vector[row] = (Boolean) val ? 1 : 0;
        } else if ("float".equals(type)) {
            consumer = (row, val) -> ((DoubleColumnVector) columnVector).vector[row] = ((Number) val).floatValue();
        } else if ("double".equals(type)) {
            consumer = (row, val) -> ((DoubleColumnVector) columnVector).vector[row] = ((Number) val).doubleValue();
        } else if ("decimal".equals(type)) {
            consumer = (row, val) -> ((DecimalColumnVector) columnVector).vector[row].set(HiveDecimal.create((BigDecimal) val));
        } else if ("string".equals(type) || type.startsWith("varchar") || "char".equals(type)) {
            consumer = (row, val) -> {
                byte[] buffer = val.toString().getBytes(StandardCharsets.UTF_8);
                ((BytesColumnVector) columnVector).setRef(row, buffer, 0, buffer.length);
            };
        } else if ("timestamp".equals(type)) {
            consumer = (row, val) -> ((TimestampColumnVector) columnVector).set(row, (Timestamp) val);
        } else {
            throw new RuntimeException("Unsupported type " + type);
        }
        return consumer;
    }
}
