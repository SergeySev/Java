package bussinesCard;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BussCardContact {
    private String fullName;
    private Tel tell;
    private Email email;
    private Address address;
    private Web web;

    public BussCardContact() {
        this.tell = new Tel();
        this.email = new Email();
        this.address = new Address();
        this.web = new Web();
    }

    @Override
    public String toString() {
        return "User:\n" +
                "FN= " + fullName + '\n' + tell + '\n' + email + '\n' + address + '\n' +  web + '\n';
    }
}


