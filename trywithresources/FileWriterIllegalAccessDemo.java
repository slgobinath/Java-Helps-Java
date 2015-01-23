import java.io.*;

public class FileWriterIllegalAccessDemo {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            // Create a FileWriter object
            writer = new FileWriter("sample.txt");
            writer.write("Hello world!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // Check for null reference
            if (writer != null) {
                try {
                    writer.close(); // Close the connection
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        try {
            writer.write("End of file.");   // IOException: Stream closed
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}