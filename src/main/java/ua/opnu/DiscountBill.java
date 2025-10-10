
class Item {
    private String name;
    private double price;
    private double discount;
    
    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getDiscount() {
        return discount;
    }
}

class Employee {
    private String name;
    
    public Employee(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

class GroceryBill {
    private Employee clerk;
    private java.util.ArrayList<Item> items;
    
    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.items = new java.util.ArrayList<>();
    }
    
    public void add(Item item) {
        items.add(item);
    }
    
    public double getTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
    public Employee getClerk() {
        return clerk;
    }
    
    public java.util.ArrayList<Item> getItems() {
        return items;
    }
    
    public void printReceipt() {
        System.out.println("Items:");
        for (Item item : items) {
            System.out.printf("%s: %.2f грн\n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: %.2f грн\n", getTotal());
    }
}

class DiscountBill extends GroceryBill {
    private boolean regularCustomer;
    private int discountCount;
    private double totalDiscount;
    
    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.totalDiscount = 0.0;
    }
    
    @Override
    public void add(Item item) {
        super.add(item);
        if (regularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            totalDiscount += item.getDiscount();
        }
    }
    
    @Override
    public double getTotal() {
        if (!regularCustomer) {
            return super.getTotal();
        }
        return super.getTotal() - totalDiscount;
    }
    
    public int getDiscountCount() {
        return discountCount;
    }
    
    public double getDiscountAmount() {
        return totalDiscount;
    }
    
    public double getDiscountPercent() {
        double totalWithoutDiscount = super.getTotal();
        if (totalWithoutDiscount == 0.0) {
            return 0.0;
        }
        return 100 - (getTotal() * 100) / totalWithoutDiscount;
    }
}
