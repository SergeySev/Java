package Train.Validation;

public class Address {
    protected String country;
    protected String city;
    protected String street;
    protected Integer houseNumber;

    public Address(String country, String city, String street, Integer houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    protected String getCountry() {
        return country;
    }

    protected String getCity() {
        return city;
    }

    protected String getStreet() {
        return street;
    }

    protected Integer getHouseNumber() {
        return houseNumber;
    }
}
