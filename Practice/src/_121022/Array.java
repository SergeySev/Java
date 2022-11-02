package _121022;

/*
    Игрок вводит одно число от 1 до 10✅
    Компьютер загадывает три числа✅
    Сравнение числа игрока с числами компьютера✅
    Если хоть одно число == числу компьютера - игрок победил✅
    Если нет - игрок проиграл✅
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите число от 1 до 10");

        byte plyerChislo = scanner.nextByte();
        ;

        while (plyerChislo < 1 || plyerChislo > 10) {
            System.out.println("Введие число как надо");
            plyerChislo = scanner.nextByte();
        }


        random.nextInt(1, 11);

        int[] lotereya = new int[3]; // [0, 0, 0]

        for (int i = 0; i < lotereya.length; i++) {
            lotereya[i] = random.nextInt(1, 11);
        }
        System.out.println("Array with random number: " + Arrays.toString(lotereya));

        boolean win = false;

        for (int i : lotereya) {
            if (plyerChislo == i) {
                System.out.println("You win!!!");
                win = true;
                break;
            }
        }
        if (win == false) {
            System.out.println("You lose");
        }


//        for (int i = 0; i < 300; i++) {
//            int a = random.nextInt(1, 11);
//            if (a < 1 || a > 10) {
//                System.out.println("Оповестить");
//            }
//            System.out.println(a);

    }
}

