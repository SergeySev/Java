package Train.Employee;
/*
В данной компании есть три вида сотрудников -
1) Резиденты страны,
2) Нерезиденты страны,
3) Контрактеры.

Нужно сделать иерархию классов для расчет налогов для каждого сотрудника.

1. Абстрактный класс Employee ✅
1.2 с protected полями taxRate (ставка подоходного налога) ✅
1.3 и socialRate (ставка соц.страхования), ✅
1.4 salary и public методом расчета налога = salary * taxRate + salary * socialRate. ✅
1.5 Можно добавить поле name, surname (для отладки и вывода) ✅

2. Создать три класса:
2.1 сотрудники-резиденты (RezidentEmployee),  ✅
2. 2 сотрудники-нерезиденты(NoRezidentEmployee),  ✅
2.3 контрактеры (Contractor). ✅
3. Задать следующие значения налогов:
3.1) RezidentEmployee: taxRate = 15%, socialRate = 10% // 15% от числа 300 = 300 * (15/100)✅
3.2) NoRezidentEmployee: taxRate = 20%, socialRate = 3% (они платят больше подоходного, но меньше соц.страхования)✅
3.3) Contractor: taxRate = 0%, socialRate = 0% (они сами платят все налоги)✅
4. Сделать несколько тестовых сотрудников каждого типа с разными зарплатами в main и посчитать налог.

Формула налога (напоминаю)
salary * taxRate + salary * socialRate.
 */
public class Employee {
    protected float taxRate;
    protected float socialRate;
    protected float salary;
    public float calculateTax;
    protected String name;
    protected String surName;

    public float getCalculateTax() {
        return (salary * taxRate) + (salary * socialRate);
    }

    public static void main(String[] args) {
        Contractor sergeyIvanov = new Contractor("Sergey", "Ivanov", 3000.23f);
        RezidentEmployee robertPattison = new RezidentEmployee("Robert", "Pattison", 344200f);
        NoRezidentEmployee mikhailJava = new NoRezidentEmployee("Mikhail", "Java", 5000f);

        System.out.println("Tax for Sergey: " + sergeyIvanov.getCalculateTax());
        System.out.println("Tax for Robert: " + robertPattison.getCalculateTax());
        System.out.println("Tax for Mikhail: " + mikhailJava.getCalculateTax());
    }

}
