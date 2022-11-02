package Train.Employee;

public class RezidentEmployee extends Employee{
    public RezidentEmployee(String name,String surName, float salary) {
        this.taxRate = 0.15f;
        this.socialRate = 0.1f;
        this.salary = salary;
        this.name = name;
        this.surName = surName;
    }
}
