package bussinesCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                if (start == true)
                    strBl.append(line).append("\n");
                if (line.contains(BEGIN_VCARD))
                    start = true;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return stringsArr;
    }

    public static void main(String[] args) {
        CardParser cardParser = new CardParser();
        System.out.println(cardParser.fileParser("input_business_card.txt"));
    }
}
