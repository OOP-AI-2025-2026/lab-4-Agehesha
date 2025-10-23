package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill2 {
    private final GroceryBill bill;
    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    public void add(Item item) {
        bill.add(item);
        if (regularCustomer && item != null) {
            double d = item.getDiscount();
            if (d > 0.0) {
                discountCount++;
                discountAmount += d;
            }
        }
    }

    public double getTotal() {
        double full = bill.getTotal();
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
        double full = bill.getTotal();
        if (full <= 0.0) return 0.0;
        double withDiscount = getTotal();
        return 100.0 - (withDiscount * 100.0) / full;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }
}
