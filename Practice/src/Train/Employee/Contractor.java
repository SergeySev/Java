package Train.Employee;

public class Contractor extends Employee{
    public Contractor(String name,String surName, float salary) {
        this.taxRate = 1;
        this.socialRate = 1;
        this.salary = salary;
        this.name = name;
        this.surName = surName;
        this.calculateTax = 0;
    }
}
