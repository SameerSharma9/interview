package org.example.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DxcInterview {
    // Employee - id, sal ,name
    public static void main(String[] args) {
        // upper case && descending order
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Alice", 10000));
        employeeList.add(new Employee(1, "Bob", 15000));
        employeeList.add(new Employee(1, "Charlie", 20000));
        employeeList.add(new Employee(2, "Alice", 34000));
        employeeList.add(new Employee(2, "Bob", 40000));
        employeeList.add(new Employee(3, "Alice", 50000));
        employeeList.add(new Employee(3, "Bob", 5000));
        employeeList.add(new Employee(2, "Demo", 100000));
        employeeList.add(new Employee(1, "test", 200000));

        employeeList.stream().peek(employee -> employee.setName(employee.getName().toUpperCase()))
                .sorted((e1, e2) -> e2.getName().compareTo(e1.getName()))
                .forEach(System.out::println);

    }
}

 class Employee{
    private int deptId;
    private String name;
    private double salary;

    public Employee(int deptId, String name, double salary) {
        this.deptId = deptId;
        this.name = name;
        this.salary = salary;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return deptId == employee.deptId && Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "deptId=" + deptId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
