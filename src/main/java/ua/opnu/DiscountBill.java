package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill extends GroceryBill {
    private final boolean preferred;
    private int discountCount = 0;
    private double discountAmount = 0.0;

    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        this.preferred = preferred;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        if (preferred) {
            double d = getItemDiscount(i);
            if (d > 0) {
                discountCount++;
                discountAmount += d;
            }
        }
    }

    @Override
    public double getTotal() {
        double total = super.getTotal();
        return preferred ? (total - discountAmount) : total;
    }

    public int getDiscountCount() { return discountCount; }
    public double getDiscountAmount() { return discountAmount; }

    public double getDiscountPercent() {
        double total = super.getTotal();
        return total == 0.0 ? 0.0 : (discountAmount / total) * 100.0;
    }

