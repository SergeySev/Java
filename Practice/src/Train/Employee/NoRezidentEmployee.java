package Train.Employee;

public class NoRezidentEmployee extends Employee{
    public NoRezidentEmployee(String name,String surName, float salary) {
        this.taxRate = 0.2f;
        this.socialRate = 0.03f;
        this.salary = salary;
        this.name = name;
        this.surName = surName;
    }
}
