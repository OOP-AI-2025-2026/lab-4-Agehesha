package ua.opnu.java.inheritance.bill;

public final class Item {
    private final String name;
    private final double price;
    private final double discount;

    public Item(String name, double price, double discount) {
        this.name = (name == null) ? "" : name;
        this.price = Math.max(0.0, price);
        double d = Math.max(0.0, discount);
        this.discount = Math.min(this.price, d);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }
}
