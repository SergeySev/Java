package Amazon;


import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/*
К нам пришел клиент, который хочет разработать онлайн магазин, похожий на Amazon. Ваша задача реализовать иерархию классов заказов.
В будущем онлайн магазине бывает два типа заказов:
1. Обычные заказы (для клиентов, которые не оплатили подписку)
2. Prime заказы (для клиентов которые оплатили подписку на Prime) - у таких заказов время доставки быстрее и доставка всегда бесплатно (то есть аналогично подписки на Amazon).
Попробуйте разрабтать следующую иерархию.
1. Абстрактный класс Order с полями ✅
 - Название товара (строка),✅
  - Адрес доставки (строка),✅
 - Стоимость товара (целое или вещественное число),✅
- Длительность доставки✅
Не абстрактным методом
  - Длительность доставки (getDeliveryDays), где возвращается поле длительность доставки,✅
и абстрактными методами       - Стоимость товара с доставкой (getPriceWithDelivery),✅
2. Класс SimpleOrder - наследник от класса Order, в котором нужно задать✅
 - Длительность доставки - всегда 5 дней,✅
Реализовать метод getPriceWithDelivery✅
 - Стоимость товара с доставкой (getPriceWithDelivery) = стоимость товара + 8 евро,✅
2. Класс PrimeOrder (заказы для клиентов с Prime)✅
 - Длительность доставки - 3 дня✅
Реализовать метод getPriceWithDelivery       - Стоимость товара с доставкой (getPriceWithDelivery) = стоимость товара,✅

Создать несколько классов с разных типов и разными данными, вывести данные товаров и методов getDeliveryDays и getPriceWithDelivery.✅

Дополнительная сложность:
1. Попробуйте создать массив из Order,✅
куда поместить несколько SimpleOrder и PrimeOrder с разными данными,✅
проитерироваться по нему (любым способом)✅
и вывести в консоль данные товаров и методов getDeliveryDays и getPriceWithDelivery.✅

2. Дополнительно к (1) попробуйте вывести так же✅
является данным заказ обычным или Prime✅
проверяя реальный класс (напоминаю, это можно сделать с помощью getClass или instanceof -✅
если есть затруднения можно найти код в интернете по этим ключевым словам),✅

3. Попробуйте дополнительно создать класс Address в котором
описать страну,
город,
улицу,
номер дома
в отдельных полях
и использовать его вместо строкого поля address в классе Order.

Во всех примерах выше, где нужно выводить данные,
постарайтесь вывести все данные из этого класса (можно использовать toString)
* */
public abstract class Order {
    protected String productName;
    protected String deliveryAddress;
    protected float productPrice;
    protected int deliveryDays;
    protected Address address; // HERE I CREATE ADRESS

    protected int getDeliveryDays() {
        return deliveryDays;
    }

    protected String getProductName() {
        return productName;
    }

    protected float getProductPrice() {
        return productPrice;
    }

    public String toStringSimple() {
        return "Customer buy:\n" +
                "Product: " + productName + "\n" +
                "Price: " +  getProductPrice() + "\n" +
                "Delivery days: " + getDeliveryDays() + "\n" +
                "Price with delivery: " + getPriceWithDelivery() + "\n";
    }

    public String toStringAddress() {
        return "Customer buy:\n" +
                "Product: " + productName + "\n" +
                "Price: " +  getProductPrice() + "\n" +
                "Delivery days: " + getDeliveryDays() + "\n" +
                "Price with delivery: " + getPriceWithDelivery() + "\n";
    }

//    public Address getAddress() {
////        return new Address().toStringAdd();
//    }


    protected abstract float getPriceWithDelivery();

    public static void main(String[] args) {
        SimpleOrder sergey = new SimpleOrder("Computer Table", "Sergeya 22", 68.99f);
        PrimeOrder duda = new PrimeOrder("Cable Manager", "Vyzov 1428", 9.99f);

        int[] numbers = new int[8];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(1, 11);
        }
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 != 0) {
                numbers[i] = 0;
            }
        }
        System.out.println(Arrays.toString(numbers));

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = (input.length() > 0) ? 1 : 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.toCharArray()[i] == ' ') {
                count++;
            }
        }
        int blockCount = "1215 544 965  d  ".split(" ").length;
        System.out.println(blockCount);
        System.out.println(input.toCharArray());
        System.out.println("Count of words is = " + count);

//        SimpleOrderAddress vycheslav = new SimpleOrderAddress(
//                "Spoon",
//                2.59f,
//                new Address(
//                        "Usa",
//                        "New York",
//                        "Vyacheslava",
//                        "56"));
//
//        PrimeOrderAddress mikhail = new PrimeOrderAddress(
//                "Tel-ran",
//                10000f,
//                new Address(
//                        "Deutschland",
//                        "Berlin",
//                        "Mikhaila",
//                        "1A"));
//
//        System.out.println(sergey.toStringSimple());
//        System.out.println(duda.toStringSimple());
//
//        System.out.println("Vycheslav");
//        System.out.println(vycheslav);
//        System.out.println("________");
//
//        System.out.println("Cycle");
//        Order[] array = {sergey, duda};
//        for (Order order : array) {
//            if (order instanceof SimpleOrder) {
//                System.out.println("---Simple Order---");
//            } else System.out.println("---Prime Order---");
//            System.out.println(order.toStringSimple());
        }
    }
//}
