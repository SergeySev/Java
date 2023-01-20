package bussinesCard;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Email {
    private Type type;
    private String internet;

    @Override
    public String toString() {
        return "EMAIL:" +
                "TYPE=" + type +
                ", INTERNET=" + internet;
    }
}
