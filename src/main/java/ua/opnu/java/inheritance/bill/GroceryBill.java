package ua.opnu.java.inheritance.bill;

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
        if (item != null) {
            items.add(item);
        }
    }

    public double getTotal() {
        double sum = 0.0;
        for (Item i : items) {
            sum += i.getPrice();
        }
        return sum;
    }

    public Employee getClerk() {
        return clerk;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
