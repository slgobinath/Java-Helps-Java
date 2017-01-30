package com.javahelps.siddhimigrationdemo;

import java.util.Random;

import org.wso2.siddhi.core.ExecutionPlanRuntime;
import org.wso2.siddhi.core.SiddhiManager;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.stream.output.StreamCallback;

public class Main {
    //    SiddhiDe
    private static final String[] CUSTOMERS = {"Alice", "Barby", "Carol", "Diana"};
    private static final String[] ITEMS = {"Cocoa-Butter Lotion", "Purse-XL", "Purse-L", "Beer", "Biscuit",
            "Chocolate", "ZMA"};
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        SiddhiManager siddhiManager = new SiddhiManager();

        String streams = "define stream purchaseStream (customerName string, item string, timestamp long); ";
        String query = "partition with (customerName of purchaseStream) " +
                "begin " +
                "from purchaseStream[item == 'Cocoa-Butter Lotion' OR item == 'Purse-XL' OR item == 'ZMA']#window" +
                ".unique:externalTimeBatch(item, timestamp, 500 milliseconds) " +
                "select customerName, convert(count(item), 'double') / 3.0 * 100.0 as noOfPurchases insert into " +
                "possiblePregnant; " +
                "end ";

        // Create ExecutionPlanRuntime using stream definition and query
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.createExecutionPlanRuntime(streams + query);

        try {
            // Receive the output events
            executionPlanRuntime.addCallback("possiblePregnant", new StreamCallback() {
                @Override
                public void receive(Event[] events) {
                    String output = String.format("\t\t\t%s is pregnant with %.2f%% confidence.", events[0].getData(0),
                            events[0].getData(1));
                    System.out.println(output);
                }
            });

            // Send input events
            InputHandler purchaseStream = executionPlanRuntime.getInputHandler("purchaseStream");
            executionPlanRuntime.start();
            for (int i = 0; i < 1000; i++) {
                Object[] event = generateEvent();
                purchaseStream.send(event);
                Thread.sleep(10); // Delay for 10 milliseconds
            }
        } finally {
            executionPlanRuntime.shutdown();
        }
    }

    private static Object[] generateEvent() {
        String name = CUSTOMERS[RANDOM.nextInt(CUSTOMERS.length)];
        String item = ITEMS[RANDOM.nextInt(ITEMS.length)];
        long time = System.currentTimeMillis(); // Current time

        System.out.println(name + " buys " + item);
        Object[] event = new Object[]{name, item, time};
        return event;
    }

}