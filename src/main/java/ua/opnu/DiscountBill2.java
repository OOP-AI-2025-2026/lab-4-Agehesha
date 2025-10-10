package ua.opnu;

import java.lang.reflect.Method;

public class DiscountBill2 {

  private final GroceryBill bill;
  private final boolean regularCustomer;

  private int discountCount;
  private double discountAmount;
  private double fullTotal;
  private double payTotal;

  public DiscountBill2(Employee clerk, boolean regularCustomer) {
    this.bill = new GroceryBill(clerk);
    this.regularCustomer = regularCustomer;
  }

  public void add(Item item) {
    if (item == null) {
      return;
    }
    bill.add(item);

    double price = item.getPrice();
    double disc = regularCustomer ? extractDiscount(item) : 0.0;

    fullTotal += price;
    payTotal += price - Math.max(0.0, disc);

    if (disc > 0.0) {
      discountCount++;
      discountAmount += disc;
    }
  }

  private double extractDiscount(Item item) {
    try {
      Method m = item.getClass().getMethod("getDiscount");
      Object v = m.invoke(item);
      if (v instanceof Number) {
        double d = ((Number) v).doubleValue();
        return d < 0 ? 0.0 : d;
      }
    } catch (Exception ignored) { }
    return 0.0;
  }

  public double getTotal() {
    return regularCustomer ? payTotal : fullTotal;
  }

  public int getDiscountCount() {
    return regularCustomer ? discountCount : 0;
  }

  public double getDiscountAmount() {
    return regularCustomer ? discountAmount : 0.0;
  }

  public double getDiscountPercent() {
    if (!regularCustomer || fullTotal <= 0.0) {
      return 0.0;
    }
    return 100.0 - (getTotal() * 100.0) / fullTotal;
  }

  public int getCount() {
    return bill.getCount();
  }

  public Employee getClerk() {
    return bill.getClerk();
  }
}
