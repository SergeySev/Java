package Train;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
* Посчитать "руку"
* Сила карты
* Сила комбинации карт
* h -чирва
* s - пика
* d - буба
* c - треф
* */


public class Practika {
    static int[] cardPowerInt = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    static String[][] cardPowerType = {{"2h", "3h", "4h", "5h", "6h", "7h", "8h", "9h", "10h", "Vh", "Dh", "Kh", "Ah"},
            {"2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s", "10s", "Vs", "Ds", "Ks", "As"},
            {"2d", "3d", "4d", "5d", "6d", "7d", "8d", "9d", "10d", "Vd", "Dd", "Kd", "Ad"},
            {"2c", "3c", "4c", "5c", "6c", "7c", "8c", "9c", "10c", "Vc", "Dc", "Kc", "Ac"}};

    public static void main(String[] args) {
        // While
        System.out.println("While");
        int i = 0;
        while (i < 0) {
            System.out.println(i);
            i++;
        }

        System.out.println("Do While");
        do {
            System.out.println(i);
            i++;
        } while (i < 0);

        // For each
        System.out.println("For each");
        for (int j : cardPowerInt) {
            System.out.println(j);
        }
        System.out.println("FOR");
        for (int q = 0; q < cardPowerInt.length; q++) {
            System.out.println(cardPowerInt[q] + " I = " + q);
        }
    }
}
