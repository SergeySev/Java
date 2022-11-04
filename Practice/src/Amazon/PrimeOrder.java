package Amazon;
//2. Класс PrimeOrder (заказы для клиентов с Prime)✅
//        - Длительность доставки - 3 дня✅
//        ✅Реализовать метод getPriceWithDelivery       - Стоимость товара с доставкой (getPriceWithDelivery) = стоимость товара,


public class PrimeOrder extends Order{

    protected PrimeOrder(String productName, String deliveryAddress, float productPrice) {
        this.deliveryDays = 3;
        this.productName = productName;
        this.deliveryAddress = deliveryAddress;
        this.productPrice = productPrice;
    }

    @Override
    protected float getPriceWithDelivery() {
        return productPrice;
    }
}
