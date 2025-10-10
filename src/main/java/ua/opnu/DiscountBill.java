package ua.opnu;


import java.lang.reflect.Method;


public class DiscountBill extends GroceryBill {
private final boolean regularCustomer;
private int discountCount;
private double discountAmount;


public DiscountBill(Employee clerk, boolean regularCustomer) {
super(clerk);
this.regularCustomer = regularCustomer;
this.discountCount = 0;
this.discountAmount = 0.0;
}


@Override
public void add(Item i) {
super.add(i); 
if (regularCustomer) {
double d = extractDiscount(i);
if (d > 0.0) {
discountCount++;
discountAmount += d;
}
}
}


@Override
public double getTotal() {
double full = super.getTotal();
if (!regularCustomer) return full;
double total = full - discountAmount;
return total < 0 ? 0 : total;
}


public int getDiscountCount() { return discountCount; }


public double getDiscountAmount() { return regularCustomer ? discountAmount : 0.0; }


public double getDiscountPercent() {
if (!regularCustomer) return 0.0;
double full = super.getTotal();
if (full <= 0.0) return 0.0;
return 100.0 * (discountAmount / full);
}


private static double extractDiscount(Object item) {
try {
Method m = item.getClass().getMethod("getDiscount");
Object val = m.invoke(item);
if (val instanceof Number) return ((Number) val).doubleValue();
} catch (Exception ignore) {
}
return 0.0;
}
}
