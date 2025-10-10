package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;


public class DiscountBill extends GroceryBill {

  private final boolean preferred;
  private int discountCount;
  private double discountAmount;

  public DiscountBill(Employee cashier, boolean preferred) {
    super(cashier);
    this.preferred = preferred;
  }

  @Override
  public void add(Item item) {
    super.add(item);
    if (preferred && item.getDiscount() > 0.0) {
      discountCount++;
      discountAmount += item.getDiscount();
    }
  }

  @Override
  public double getTotal() {
    double base = super.getTotal();
    return preferred ? base - discountAmount : base;
  }

 
  public int getDiscountCount() {
    return preferred ? discountCount : 0;
  }


  public double getDiscountAmount() {
    return preferred ? discountAmount : 0.0;
  }


  public double getDiscountPercent() {
    double base = super.getTotal();
    if (!preferred || base <= 0.0) {
      return 0.0;
    }
    return (discountAmount / base) * 100.0;
  }
}
