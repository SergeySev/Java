package Train.Calculator;

import java.util.Arrays;
import java.util.Random;

public class _1610HomeWork {
    public static void main(String[] args) {
        int min = 0;
        int max = 10;
        int[] arrayNumber = new int[22];

        Random random = new Random();

        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = random.nextInt(11);
        }
        System.out.println(Arrays.toString(arrayNumber));

        // Random char
        char[] arrayChar = new char[32];
        for (int i = 0; i < arrayChar.length; i++) {
            arrayChar[i] = (char) random.nextInt(97, 123);
        }
        System.out.println(arrayChar);
    }
}
