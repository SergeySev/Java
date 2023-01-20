package bussinesCard;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


public class Web {
    private Type type;
    private String internet;

    @Override
    public String toString() {
        return "WEB:" +
                "TYPE=" + type +
                ", INTERNET='" + internet;
    }
}
