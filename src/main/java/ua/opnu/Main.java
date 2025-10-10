package ua.opnu;

public class Main {

    public static void main(String[] args) {
        System.out.println("Lab 4 runner");

        Point3D p = new Point3D(1, 2, 3);
        System.out.println("Point3D = " + p + ", dist0 = " + String.format("%.4f", p.distanceFromOrigin()));

        checkClass("ua.opnu.DiscountBill");
        checkClass("ua.opnu.DiscountBill2");
        checkClass("ua.opnu.MinMaxAccount");
        checkClass("ua.opnu.Point3D");

        System.out.println("OK");
    }

    private static void checkClass(String fqcn) {
        try {
            Class.forName(fqcn);
            System.out.println(fqcn + " — OK");
        } catch (ClassNotFoundException e) {
            System.out.println(fqcn + " — NOT FOUND");
        }
    }
}
