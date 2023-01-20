package bussinesCard;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
    private Type type;
    private String country;
    private String city;
    private String street;

    @Override
    public String toString() {
        return "ADDRESS:" +
                "TYPE=" + type +
                ", COUNTRY='" + country + '\'' +
                ", CITY='" + city + '\'' +
                ", STREET='" + street + '\'';
    }
}
