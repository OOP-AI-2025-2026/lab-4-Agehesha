
package org.example.lab4.discount;

import org.example.lab4.docsmodel.Employee;
import org.example.lab4.docsmodel.GroceryBill;
import org.example.lab4.docsmodel.Item;

public class DiscountBill extends GroceryBill {
    private final boolean regularCustomer;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item item) {
        super.add(item);
    }

    @Override
    public double getTotal() {
        if (!regularCustomer) return super.getTotal();
        double sum = 0.0;
        for (Item it : getItems()) {
            double price = Math.max(0.0, it.getPrice());
            double disc = Math.max(0.0, it.getDiscount());
            if (disc > price) disc = price;
            sum += (price - disc);
        }
        return sum;
    }


    public int getDiscountCount() {
        if (!regularCustomer) return 0;
        int c = 0;
        for (Item it : getItems()) {
            double disc = Math.max(0.0, Math.min(it.getDiscount(), it.getPrice()));
            if (disc > 0.0) c++;
        }
        return c;
    }

    public double getDiscountAmount() {
        if (!regularCustomer) return 0.0;
        double d = 0.0;
        for (Item it : getItems()) {
            double disc = Math.max(0.0, Math.min(it.getDiscount(), it.getPrice()));
            d += disc;
        }
        return d;
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return 0.0;
        double full = super.getTotal();
        if (full <= 0.0) return 0.0;
        double discounted = getTotal();
        return 100.0 - (discounted * 100.0) / full;
    }
}
