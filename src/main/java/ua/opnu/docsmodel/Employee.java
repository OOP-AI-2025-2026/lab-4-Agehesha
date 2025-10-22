
package org.example.lab4.docsmodel;

public class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name == null ? "" : name;
    }

    public String getName() { return name; }
}
