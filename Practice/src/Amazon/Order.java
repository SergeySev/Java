package Amazon;

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
и абстрактными методами - Стоимость товара с доставкой (getPriceWithDelivery),✅
2. Класс SimpleOrder - наследник от класса Order, в котором нужно задать✅
 - Длительность доставки - всегда 5 дней,✅
Реализовать метод getPriceWithDelivery✅
 - Стоимость товара с доставкой (getPriceWithDelivery) = стоимость товара + 8 евро,✅
2. Класс PrimeOrder (заказы для клиентов с Prime)✅
 - Длительность доставки - 3 дня✅
Реализовать метод getPriceWithDelivery - Стоимость товара с доставкой (getPriceWithDelivery) = стоимость товара,✅

Создать несколько классов с разных типов и разными данными, вывести данные товаров и методов getDeliveryDays и getPriceWithDelivery.✅

Дополнительная сложность:
1. Попробуйте создать массив из Order, ✅
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
    protected Address address;

    protected int getDeliveryDays() {
        return deliveryDays;
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
                "Price with delivery: " + getPriceWithDelivery() + "\n" +
                "Adress delivery:\nCountry: "+ address.getCountry() + "\n" +
                "City: " + address.getCity() + "\n" +
                "Street: " + address.getStreet() + "\n" +
                "House: " + address.getHouse();
    }


    protected abstract float getPriceWithDelivery();

    public static void main(String[] args) {
        SimpleOrder sergey = new SimpleOrder("Computer Table", "Sergeya 22", 68.99f);
        PrimeOrder duda = new PrimeOrder("Cable Manager", "Vyzov 1428", 9.99f);

        SimpleOrderAddress vycheslav = new SimpleOrderAddress(
                "Spoon",
                2.59f,
                new Address(
                        "Usa",
                        "New York",
                        "Vyacheslava",
                        "56"));

        PrimeOrderAddress mikhail = new PrimeOrderAddress(
                "Tel-ran",
                10000f,
                new Address(
                        "Deutschland",
                        "Berlin",
                        "Mikhaila",
                        "1A"));

        System.out.println(sergey.toStringSimple());
        System.out.println(duda.toStringSimple());

        System.out.println("Vycheslav");
        System.out.println(vycheslav.toStringAddress());
        System.out.println();
        System.out.println(mikhail.toStringAddress());
        System.out.println("________");

        System.out.println("Cycle");
        Order[] array = {sergey, duda};
        for (Order order : array) {
            if (order instanceof SimpleOrder) {
                System.out.println("---Simple Order---");
            } else System.out.println("---Prime Order---");
            System.out.println(order.toStringSimple());
        }
    }
}
