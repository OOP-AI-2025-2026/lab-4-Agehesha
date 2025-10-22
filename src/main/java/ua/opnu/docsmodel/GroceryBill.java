
package org.example.lab4.docsmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroceryBill {
    private final Employee clerk;
    private final List<Item> items = new ArrayList<>();

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
    }

    public void add(Item item) {
        if (item != null) items.add(item);
    }

    public double getTotal() {
        double sum = 0.0;
        for (Item it : items) sum += it.getPrice();
        return sum;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Employee getClerk() { return clerk; }
}
