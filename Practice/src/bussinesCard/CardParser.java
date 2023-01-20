package bussinesCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardParser {
    final String BEGIN_VCARD = "BEGIN:VCARD";
    final String END_VCARD = "END:VCARD";

    public List<String> fileParser(String filePath) {
        List<String> stringsArr = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean start = false;
            StringBuilder strBl = new StringBuilder();
            while ((line = bf.readLine()) != null) {
                if (line.contains(END_VCARD)) {
                    start = false;
                    stringsArr.add(strBl.toString());
                    strBl = new StringBuilder();
                }
                if (start)
                    strBl.append(line).append("\n");
                if (line.contains(BEGIN_VCARD))
                    start = true;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return stringsArr;
    }

    public void userParser(List<String> users) {
        List<BussCardContact> usersData = new ArrayList<>();
        for (String user :
                users) {
            usersData.add(createUser(user));
        }
        usersData.forEach(System.out::println);
    }


    private BussCardContact createUser(String contact) {
        BussCardContact person = new BussCardContact();
        String regex = "^(FN|TEL|EMAIL|ADDRESS|WEB)[:|;](TYPE=.*:|)(.+)$";

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(contact);

        while (matcher.find()) {
            String group = matcher.group(1);
            String type = matcher.group(2);
            String value = replaceFirstSpace(matcher.group(3));
            switch (group) {
                case ("FN") -> person.setFullName(replaceFirstSpace(value));
                case ("TEL") -> {
                    if ("WORK".equals(getType(type))) {
                        person.getTell().setType(Type.WORK);
                    }
                    person.getTell().setVoice(value);
                }
                case ("EMAIL") -> {
                    if ("PREF".equals(getType(type))) {
                        person.getEmail().setType(Type.PREF);
                    }
                    person.getEmail().setInternet(value);
                }
                case ("ADDRESS") -> {
                    switch (getAddressType(type)) {
                        case ("STREET") -> person.getAddress().setStreet(value);
                        case ("CITY") -> person.getAddress().setCity(value);
                        case ("COUNTRY") -> person.getAddress().setCountry(value);
                    }
                    switch (getType(type)) {
                        case ("WORK") -> person.getAddress().setType(Type.WORK);
                        case ("HOME") -> person.getAddress().setType(Type.HOME);
                    }
                }
                case ("WEB") -> {
                    if ("PREF".equals(getType(type))) {
                        person.getWeb().setType(Type.PREF);
                    }
                    person.getWeb().setInternet(value);
                }
            }
        }
        return person;
    }

    private String replaceFirstSpace(String str) {
        return (str.startsWith(" ")) ? str.replaceFirst(" ", "") : str;
    }

    private String getAddressType(String str) {
        if (str.isEmpty()) return str;
        int indexLastComa = str.lastIndexOf(',');
        int indexTwoDots = str.lastIndexOf(':');
        return str.substring(indexLastComa + 1, indexTwoDots);
    }

    private String getType(String str) {
        int indexComa = str.indexOf(',');
        int indexEqual = str.indexOf('=');
        return str.substring(indexEqual + 1, indexComa);
    }

    public static void main(String[] args) {
        CardParser cardParser = new CardParser();
        String path = "input_business_card.txt";
        cardParser.userParser(cardParser.fileParser(path));
    }
}
