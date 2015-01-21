public class SingleSales {
    public static void main(String[] args) {
        doStuff(new Pen(10.00));
        doStuff(new Book(250.00, 5.00));
    }

    public static void doStuff(Sellable item) {
        double income = item.sell();
        System.out.println("Income: $" + income);
    }
}

interface Sellable {
    double sell();
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