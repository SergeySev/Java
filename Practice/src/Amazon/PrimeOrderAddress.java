package Amazon;
//2. Класс PrimeOrder (заказы для клиентов с Prime)✅
//        - Длительность доставки - 3 дня✅
//        ✅Реализовать метод getPriceWithDelivery       - Стоимость товара с доставкой (getPriceWithDelivery) = стоимость товара,


public class PrimeOrderAddress extends Order{

    public PrimeOrderAddress(String productName, float productPrice, Address address) {
        this.deliveryDays = 3;
        this.productName = productName;
        this.productPrice = productPrice;
        this.address = address;
    }

    @Override
    protected float getPriceWithDelivery() {
        return productPrice;
    }
}
