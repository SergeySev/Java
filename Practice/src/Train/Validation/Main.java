package Train.Validation;

import java.util.LinkedList;

/*
* Необязательное домашнее задание.

В нашей системе регистрируется много пользователей, мы обнаружили, что часто они вводят неправильные данные.
Нужно реализовать сервис валидации (UserValidationService), который реализует методы

public boolean isCorrectUsers(User users); // возвращает булевое значение - правильный пользователь или нет✅

public User[] getIncorrectUsers(User[] users); // здесь можно вызывать метод isCorrectUsers в цикле ✅

Модель данных пользователей.

User {
  String name;
  String surname;
  Address address;
  String email;
  String phone;
}✅

Address {
   String country;
   String city;
   String street;
   Integer houseNumber;
}✅

Сервис валидации может проверять (не обязательно делать все условия, можно только несколько).
  1. То что все поля всех классов заполнены (смотреть != null и isEmpty методы),✅
  2. Email содержит символ @ (смотреть метод String contains() метод - https://www.w3schools.com/java/ref_string_contains.asp),✅
  3. country содержит значения из заданного массива стран (например, Germany, Poland, France, Luxembourg),✅
  4. Email содержит как минимум один символ точки (.) ✅
  *
  * и он находится после первого @ -
  * Неверное условие__________
  *
  * (смотреть indexOf - https://www.w3schools.com/java/ref_string_indexof.asp и lastIndexOf методы -
  * https://www.w3schools.com/java/ref_string_lastindexof.asp),

Нужно сделать тестовый класс, где создать несколько разных User (правильных и нет) и проверить, что все методы
* возвращают правильные результаты.

P.S. Бонусное задание посмотреть статьи про Unit тесты и реализовать хотя бы простейший Unit test.
*
*
* */
public class Main {
    public static void main(String[] args) {
        UserValidationService validation = new UserValidationService();
        User user1 = new User("A", "B", new Address("Андорра", "D", "E", 1), "f.j.j@google.ua", "G");
        User user2 = new User("", "B", new Address("Андорра", "D", "E", 1), "f.j.j@google.ua", "G");

        System.out.println(validation.isCorrectUsers(user1));

        LinkedList<User> test = new LinkedList<>();
        test.add(user1);
        test.add(user2);

        validation.getIncorrectUsers(test);
    }
}
