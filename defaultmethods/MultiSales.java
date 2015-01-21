public class MultiSales {
    public static void main(String[] args) {
        doStuff(new Pen(10.00), 5);
        doStuff(new Book(250.00, 5.00), 2);
    }

    public static void doStuff(Sellable item, int count) {
        double income = item.sell(count);
        System.out.println("Income: $" + income);
    }
}

interface Sellable {
    double sell();

    default double sell(int count) {
        double total = 0.0;
        for(int i = 1; i <= count; i++) {
            total += this.sell();
        }
        return total;
    }

    default String toString() {
        return "df";
    }
}

class Book implements Sellable {
    private double price;
    private double discount;

    public Book(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }

    @Override
    public double sell() {
        return price - (price * discount / 100.00);
    }
}

class Pen implements Sellable {
    private double price;

    public Pen(double price) {
        this.price = price;
    }

    @Override
    public double sell() {
        return price;
    }
}