/**
 * In real world USB port is a point of interaction - Interface.
 * This code simulates the real world scenario using interface.
 *
 * @author L.Gobinath
 */
public class Computer {
    public static void main(String[] args) {
        Computer comp = new Computer();
    }

    public void connect(USB usb) {
        usb.send(new byte[] {1});   // Send some data
        byte[] data = usb.receive();    // Receive some data
        // do something here
    }
}

interface USB {
    void send(byte[] data);

    byte[] receive();
}

class Mouse implements USB {
    @Override
    public void send(byte[] data) {
        System.out.println("Connected");
    }

    @Override
    public byte[] receive() {
        return new byte[] {120, 87};
    }
}