package Train.Validation;

import java.util.LinkedList;

public class UserValidationService {

    public boolean isCorrectUsers(User user) // возвращает булевое значение, правильный ли это пользователь
    {
//        List<Object> userData = new LinkedList<>(name, surname, country, city, street, houseNumber, email, phone);

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

        return checkEmailLength(user.getEmail())
                && isFieldEmpty(user)
                && checkCountryIsFalse(user)
                && !(user.getAddress().getHouseNumber() == 0)
                && checkEmailDog(user)
                && checkEmailDomein(user)
                && checkEmailFirstEl(user)
                && checkEmailDot(user)
                && checkEmailContainWrongEl(user);
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

    public static boolean checkEmailDog(User user) {
        return user.getEmail().contains("@");
    }

    public static boolean checkEmailDomein(User user) {

        // Verify the missing domain in the email id field

        String email = user.getEmail();
        int length = email.length();
        return email.substring(length - 4).equals(".com") ||
                email.substring(length - 3).equals(".ua") ||
                email.substring(length - 3).equals(".ru") ||
                email.substring(length - 3).equals(".de");
    }

    public static boolean checkEmailFirstEl(User user) {
        return !(user.getEmail().indexOf('@') == 0);
    }

    public static boolean checkEmailDot(User user) {
        String email = user.getEmail();
        return !(email.indexOf('.') == 0 || email.charAt(email.indexOf('@') - 1) == '.');
    }

    public static boolean checkEmailContainWrongEl(User user) {
        String email = user.getEmail();
        char[] emailToChar = email.toCharArray();
        int countDog = 0;
        for (int i = 0; i < emailToChar.length; i++) {
            /*
             Verify multiple dots in the email field
             Verify contains wrong element
             */
            if (!(emailToChar[i] > 32 && emailToChar[i] < 94) && !(emailToChar[i] > 94 && emailToChar[i] < 126)) {
                return false;
            }
            try {
                if (emailToChar[i] == '.' && (emailToChar[i - 1] == '.' || emailToChar[i + 1] == '.')) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
            if (emailToChar[i] == '@') {
                countDog++;
            }
        }
        // Verify for count '@' if it bigger than 1 - email not valid
        return countDog <= 1;
    }

    public boolean isFieldEmpty(User user) {
        Object[] userData = getData(user);
        for (Object userDatum : userData) {
//            System.out.println(userDatum);
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
//    protected List<Object> getData(User users) {
//        return new List<Object> (users.getName(), users.getSurname(), users.getAddress().getCountry(),
//                users.getAddress().getCity(), users.getAddress().getStreet(), users.getAddress().getHouseNumber(),
//                users.getEmail(), users.getPhone());
//    }

//    public User[] getIncorrectUsers(User[] users) // здесь можно вызывать метод isCorrectUsers в цикле
//    {
//        return new User[0];
//    }
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
