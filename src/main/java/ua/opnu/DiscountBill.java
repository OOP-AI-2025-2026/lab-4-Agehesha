package ua.opnu;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DiscountBill extends GroceryBill {

  private final boolean regularCustomer;
  private final List<Item> items = new ArrayList<>();

  private int discountCount;
  private double discountAmount;
  private double fullTotal;
  private double payTotal;

  public DiscountBill(Employee clerk, boolean regularCustomer) {
    super(clerk);
    this.regularCustomer = regularCustomer;
  }

  @Override
  public void add(Item item) {
    if (item == null) {
      return;
    }
    super.add(item); 
    items.add(item);

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
    } catch (Exception ignored) {
    }
    return 0.0;
  }

  @Override
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
}
