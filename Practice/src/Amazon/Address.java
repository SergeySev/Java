package Amazon;

public class Address extends Order{
    protected String country;
    protected String city;
    protected String street;
    protected String house;

    protected Address(String country, String city, String street, String house) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    protected  String getCountry() {
        return country;
    }

    protected  String getCity() {
        return city;
    }

    protected  String getStreet() {
        return street;
    }

    protected  String getHouse() {
        return house;
    }

//    @Override
    public String toStringAdd() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                '}';
    }

    @Override
    protected float getPriceWithDelivery() {
        return 0;
    }
}