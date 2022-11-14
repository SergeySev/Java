package Train.Validation;

import javax.xml.stream.events.Characters;
import java.util.LinkedList;

public class UserValidationService {

    public boolean isCorrectUsers(User user) // возвращает булевое значение, правильный ли это пользователь
    {
        /*
        Return true - if user correct
        * Check email for content:
        Verify an email id cannot exceed 254 characters.✅
        Verify the missing @ symbol in the email id field.✅
        Verify the missing domain in the email id field.✅
        Verify gibberish or garbage is not accepted in the email id text box.✅
        Verify the missing username in the email id field.✅
        Verify encoded HTML within the email id field is invalid. WHAT IS IT???????????????????????
        Verify leading dot in the email id text box is invalid.✅
        Verify trailing dot in the email id text box is invalid.✅
        Verify multiple dots in the email field.✅
        Verify unicode char in the address in the email text box.✅
        * */

        return isFieldEmpty(user)
                && checkCountryIsFalse(user)
                && !(user.getAddress().getHouseNumber() == 0)
                && isEmailValid(user.getEmail());
    }

    private boolean isEmailValid(String email) {
        return checkEmailDog(email)
                && checkEmailTwoDots(email)
                && checkEmailDomein(email)
                && checkEmailFirstEl(email)
                && checkEmailDot(email)
                && checkEmailContainWrongEl(email)
                && checkEmailLength(email)
                && checkEmailTwoDogs(email);
    }
    private boolean checkCountryIsFalse(User user) {
        String[] countries = {"Австралия", "Австрия", "Азербайджан", "Албания", "Алжир", "Ангилья", "Англия", "Ангола",
                "Андорра", "Антигуа и Барбуда", "Аргентина", "Армения", "Аруба", "Афганистан", "Израиль", "Индия",
                "Индонезия", "Иордания", "Ирак", "Иракский Курдистан", "Иран", "Ирландия", "Исландия", "Испания",
                "Италия"};
        for (String country : countries) {
            if (country.equals(user.getAddress().getCountry())) {
                return true;
            }
        }
        System.out.println("Wrong Country");
        return false;
    }

    public static boolean checkEmailLength(String emailLength) {
        return emailLength.length() < 255;
    }

    public static boolean checkEmailDog(String email) {
        return email.contains("@");
    }

    public static boolean checkEmailDomein(String email) {

        // Verify the missing domain in the email id field

        int length = email.length();
        return email.substring(length - 4).equals(".com") ||
                email.substring(length - 3).equals(".ua") ||
                email.substring(length - 3).equals(".ru") ||
                email.substring(length - 3).equals(".de");
    }

    public static boolean checkEmailFirstEl(String email) {
        return email.indexOf('@') != 0;
    }

    public static boolean checkEmailDot(String email) {
        return !(email.indexOf('.') == 0 || email.charAt(email.indexOf('@') - 1) == '.');
    }

    public static boolean checkEmailTwoDogs(String email) {
        return email.indexOf("@") == email.lastIndexOf("@");
    }

    public static boolean checkEmailContainWrongEl(String email) {
        char[] emailToChar = email.toCharArray();
        for (int i = 0; i < emailToChar.length; i++) {
            /*
             Verify contains wrong element
             */
            if (!(emailToChar[i] > 32 && emailToChar[i] < 94) && !(emailToChar[i] > 94 && emailToChar[i] < 126)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkEmailTwoDots(String email){
        return !email.contains("..");
    }


    public boolean isFieldEmpty(User user) {
        Object[] userData = getData(user);
        for (Object userDatum : userData) {
            if (userDatum.toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    protected Object[] getData(User users) {
        return new Object[]{users.getName(), users.getSurname(), users.getAddress().getCountry(),
                users.getAddress().getCity(), users.getAddress().getStreet(), users.getAddress().getHouseNumber(),
                users.getEmail(), users.getPhone()};
    }

    public LinkedList<User> getIncorrectUsers(LinkedList<User> users) // здесь можно вызывать метод isCorrectUsers в цикле
    {
        LinkedList<User> wrongUsers = new LinkedList<>();
        for (User user : users) {
            if (!isCorrectUsers(user)) {
             wrongUsers.add(user);
            }
        }
        for (User wrongUser : wrongUsers) {
            System.out.println(wrongUser.toString());
        }
        return wrongUsers;
    }
}
