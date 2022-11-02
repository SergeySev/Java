package Amazon;
//2. Класс SimpleOrder - наследник от класса Order, в котором нужно задать✅
//        - Длительность доставки - всегда 5 дней,✅
//        Реализовать метод getPriceWithDelivery
//        - Стоимость товара с доставкой (getPriceWithDelivery) = стоимость товара + 8 евро,✅
public class SimpleOrderAddress extends Order{

    public SimpleOrderAddress(String productName, float productPrice, Address address) {
        this.deliveryDays = 5;
        this.productName = productName;
        this.productPrice = productPrice;
        this.address = address;
    }

    @Override
    protected float getPriceWithDelivery() {
        return productPrice + 8;
    }

    @Override
    public String toString() {
        return "SimpleOrderAddress{" +
                "productName='" + productName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", productPrice=" + productPrice +
                ", deliveryDays=" + deliveryDays + '}';
    }
}
