package Train.Validation;

public class User {
    protected String name;
    protected String surname;
    protected Address address;
    protected String email;
    protected String phone;

    public User(String name, String surname, Address address, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    protected String getName() {
        return name;
    }

    protected String getSurname() {
        return surname;
    }

    protected Address getAddress() {
        return address;
    }

    protected String getEmail() {
        return email;
    }

    protected String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
