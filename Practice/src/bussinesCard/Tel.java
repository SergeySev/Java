package bussinesCard;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Tel {
    private Type type;
    private String voice;

    @Override
    public String toString() {
        return "TEL:" +
                "TYPE=" + type +
                ", VOICE=" + voice;
    }
}
