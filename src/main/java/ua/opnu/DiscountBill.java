package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

/**
 * Вариант из классического задания: если клиент preferred,
 * то скидки применяются и считаются статистики.
 */
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

    /** Полная сумма с учётом статуса preferred. */
    @Override
    public double getTotal() {
        double total = super.getTotal();
        return preferred ? (total - discountAmount) : total;
    }

    public int getDiscountCount() { return discountCount; }
    public double getDiscountAmount() { return discountAmount; }

    /** Процент скидки относительно суммы без скидки. */
    public double getDiscountPercent() {
        double total = super.getTotal();
        return total == 0.0 ? 0.0 : (discountAmount / total) * 100.0;
    }

    /** Универсально берём скидку из Item (
