import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("sample.txt")) {
            writer.write("Hello world!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } // No close statements
        // Cannot access writer here
    }
}