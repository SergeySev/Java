package Train.CompanyWorker;
 /*
 Сделать проект для Сотрудников компании.
 Должен быть класс Сотрудники, ✅
 ЭНАМЫ с градацией должностей.✅
 Интерфейсы с фичами для каждого уровня должности.✅
 Наследники от главного класса будут ТОПы, Среднего звена, Рядовые сотрудники.✅
 Хранить сотрудников в папке model.✅
 Далее сделать класс базаДанных по аналогии с уроком.✅
 Хранить класс в папке bd.✅
 Сделать класс Сервис, который будет выполнять разного рода опреации, анпрмер смены должности итд.
 Хранить Сервисы в папке service ✅
  */

public class Worker {
    String name;
    String surName;
    Position position;
    Integer salary;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Position getPosition() {
        return position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }

    public Worker(String name, String surName, Position position, Integer salary) {
        this.name = name;
        this.surName = surName;
        this.position = position;
        this.salary = salary;
    }

    public Worker() {
    }
}
