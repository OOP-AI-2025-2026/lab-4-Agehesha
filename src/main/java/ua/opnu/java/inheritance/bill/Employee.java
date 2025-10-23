package ua.opnu.java.inheritance.bill;

public final class Employee {
    private final String name;

    public Employee(String name) {
        this.name = (name == null) ? "" : name;
    }

    public String getName() {
        return name;
    }
}
