package Train.Validation;

public class UserValidationService {

    public boolean isCorrectUsers(User user) // возвращает булевое значение, правильный ли это пользователь
    {
//        List<Object> userData = new LinkedList<>(name, surname, country, city, street, houseNumber, email, phone);

        /*
        * Check email for content:
        Verify an email id cannot exceed 254 characters.✅
        Verify the missing @ symbol in the email id field.✅
        Verify the missing domain in the email id field.✅
        Verify gibberish or garbage is not accepted in the email id text box.
        Verify the missing username in the email id field.✅
        Verify encoded HTML within the email id field is invalid. WHAT IS IT???????????????????????
        Verify leading dot in the email id text box is invalid.✅
        Verify trailing dot in the email id text box is invalid.✅
        Verify multiple dots in the email field.✅
        Verify unicode char in the address in the email text box.✅
        * */

        if (isFieldEmpty(user)) {
            return false;
        } else if (!checkEmail(user)) {
            return false;
        } else if (!checkCountryIsFalse(user)) {
            return false;
        } else if (user.getAddress().getHouseNumber() == 0) {
            return false;
        }
        return true;
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
        return false;
    }

    public boolean checkEmail(User user) {
        Object[] userData = getData(user);
        String email = userData[6].toString();
        int length = email.length();

        if (length > 254) {

            // Verify an email id cannot exceed 254 characters

            return false;
        } else if (!email.contains("@")) {

            // Verify the missing domain in the email id field

            return false;
        } else if (!email.substring(length - 4).equals(".com") &&
                !email.substring(length - 3).equals(".ua") &&
                !email.substring(length - 3).equals(".ru") &&
                !email.substring(length - 3).equals(".de")) {

            // Verify the missing domain in the email id field

            return false;
        } else if (email.indexOf('@') == 0) {

            // Verify the missing username in the email id field

            return false;
        } else if (email.indexOf('.') == 0 || email.charAt(email.indexOf('@') - 1) == '.') {
            /*
            Verify leading dot in the email id text box is invalid
            Verify trailing dot in the email id text box is invalid
            */
            return false;
        }
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
        if (countDog > 1) {
            // Verify for count '@' if it bigger than 1 - email not valid
            return false;
        }
        return true;
    }

    public boolean isFieldEmpty(User user) {
        Object[] userData = getData(user);
        for (Object userDatum : userData) {
//            System.out.println(userDatum);
            if (userDatum.toString().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    protected Object[] getData(User users) {
        return new Object[]{users.getName(), users.getSurname(), users.getAddress().getCountry(),
                users.getAddress().getCity(), users.getAddress().getStreet(), users.getAddress().getHouseNumber(),
                users.getEmail(), users.getPhone()};
    }

    public User[] getIncorrectUsers(User[] users) // здесь можно вызывать метод isCorrectUsers в цикле
    {
        return new User[0];
    }
}
