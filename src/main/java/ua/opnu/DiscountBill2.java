// file: src/main/java/org/example/lab4/discount/DiscountBill2.java
package org.example.lab4.discount;

import org.example.lab4.docsmodel.Employee;
import org.example.lab4.docsmodel.GroceryBill;
import org.example.lab4.docsmodel.Item;

import java.util.List;

public class DiscountBill2 {
    private final GroceryBill base;
    private final boolean regularCustomer;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.base = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public void add(Item item) { base.add(item); }

    public double getTotal() {
        if (!regularCustomer) return base.getTotal();
        double sum = 0.0;
        for (Item it : base.getItems()) {
            double price = Math.max(0.0, it.getPrice());
            double disc = Math.max(0.0, Math.min(it.getDiscount(), price));
            sum += (price - disc);
        }
        return sum;
    }

    public int getDiscountCount() {
        if (!regularCustomer) return 0;
        int c = 0;
        for (Item it : base.getItems()) {
            double disc = Math.max(0.0, Math.min(it.getDiscount(), it.getPrice()));
            if (disc > 0.0) c++;
        }
        return c;
    }

    public double getDiscountAmount() {
        if (!regularCustomer) return 0.0;
        double d = 0.0;
        for (Item it : base.getItems()) {
            double disc = Math.max(0.0, Math.min(it.getDiscount(), it.getPrice()));
            d += disc;
        }
        return d;
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return 0.0;
        double full = base.getTotal();
        if (full <= 0.0) return 0.0;
        double discounted = getTotal();
        return 100.0 - (discounted * 100.0) / full;
    }

    public Employee getClerk() { return base.getClerk(); }
    public List<Item> getItems() { return base.getItems(); }
}
