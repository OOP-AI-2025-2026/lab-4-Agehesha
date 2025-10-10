package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;


public class DiscountBill2 {

  private final GroceryBill bill;
  private final boolean preferred;
  private int discountCount;
  private double discountAmount;

  public DiscountBill2(Employee cashier, boolean preferred) {
    this.bill = new GroceryBill(cashier);
    this.preferred = preferred;
  }

  public void add(Item item) {
    bill.add(item);
    if (preferred && item.getDiscount() > 0.0) {
      discountCount++;
      discountAmount += item.getDiscount();
    }
  }

  public double getTotal() {
    double base = bill.getTotal();
    return preferred ? base - discountAmount : base;
  }

  public int getDiscountCount() {
    return preferred ? discountCount : 0;
  }

  public double getDiscountAmount() {
    return preferred ? discountAmount : 0.0;
  }

  public double getDiscountPercent() {
    double base = bill.getTotal();
    if (!preferred || base <= 0.0) {
      return 0.0;
    }
    return (discountAmount / base) * 100.0;
  }
}
