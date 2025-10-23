package ua.opnu.java.inheritance.bill;

import java.util.List;

public class DiscountBill extends GroceryBill {
    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item item) {
        super.add(item);
        if (regularCustomer && item != null && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += Math.min(item.getPrice(), item.getDiscount());
        }
    }

    @Override
    public double getTotal() {
        if (!regularCustomer) {
            return super.getTotal();
        }
        double total = 0.0;
        List<Item> list = getItems();
        for (Item i : list) {
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
        for (Item i : getItems()) {
            full += i.getPrice();
        }
        if (full <= 0.0 || !regularCustomer) {
            return 0.0;
        }
        return 100.0 - (getTotal() * 100.0 / full);
    }
}
