package Amazon;
//2. Класс SimpleOrder - наследник от класса Order, в котором нужно задать✅
//        - Длительность доставки - всегда 5 дней,✅
//        Реализовать метод getPriceWithDelivery
//        - Стоимость товара с доставкой (getPriceWithDelivery) = стоимость товара + 8 евро,✅
public class SimpleOrder extends Order{

    protected SimpleOrder(String productName, String deliveryAddress, float productPrice) {
        this.deliveryDays = 5;
        this.productName = productName;
        this.deliveryAddress = deliveryAddress;
        this.productPrice = productPrice;
    }

    @Override
    protected float getPriceWithDelivery() {
        return productPrice + 8;
    }
}
