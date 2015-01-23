import java.io.*;

public class TryWithMultiResources {
    public static void main(String[] args) {
    	// Notice the semicolons
        try (FileWriter fw = new FileWriter("sample.txt");
        	BufferedWriter writer = new BufferedWriter(fw);) {
            writer.write("Hello world!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}