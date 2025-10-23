package ua.opnu.java.inheritance.bill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DiscountBill2 {
    private final GroceryBill base;
    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.base = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public void add(Item item) {
        base.add(item);
        if (regularCustomer && item != null && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += Math.min(item.getPrice(), item.getDiscount());
        }
    }

    public double getTotal() {
        if (!regularCustomer) {
            return base.getTotal();
        }
        double total = 0.0;
        for (Item i : base.getItems()) {
            double disc = Math.min(i.getDiscount(), i.getPrice());
            total += i.getPrice() - disc;
        }
        return total;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        double full = 0.0;
        for (Item i : base.getItems()) {
            full += i.getPrice();
        }
        if (full <= 0.0 || !regularCustomer) {
            return 0.0;
        }
        return 100.0 - (getTotal() * 100.0 / full);
    }

    public Employee getClerk() {
        return base.getClerk();
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(new ArrayList<>(base.getItems()));
    }
}
