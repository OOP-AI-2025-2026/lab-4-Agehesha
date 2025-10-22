
package org.example.lab4.docsmodel;


public class Item {
    private final String name;
    private final double price;
    private final double discount;

    public Item(String name, double price, double discount) {
        this.name = name == null ? "" : name;
        double p = Math.max(0.0, price);
        double d = Math.max(0.0, discount);
        if (d > p) d = p;
        this.price = p;
        this.discount = d;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getDiscount() { return discount; }
}
