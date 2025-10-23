package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill extends GroceryBill {
    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item item) {
        super.add(item);
        if (regularCustomer && item != null) {
            double d = item.getDiscount();
            if (d > 0.0) {
                discountCount++;
                discountAmount += d;
            }
        }
    }

    @Override
    public double getTotal() {
        double full = super.getTotal();
        if (!regularCustomer) return full;
        double withDiscount = full - discountAmount;
        return withDiscount < 0.0 ? 0.0 : withDiscount;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return 0.0;
        double full = super.getTotal();
        if (full <= 0.0) return 0.0;
        double withDiscount = getTotal();
        return 100.0 - (withDiscount * 100.0) / full;
    }
}
