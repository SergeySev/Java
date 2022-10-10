import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Calculator {

    public static long sumNumber(int num1, int num2)
    {
        return (long) num1 + (long) num2;
    }

    public static double sumNumber(double num1, double num2) {
        return num1 + num2;
    }

    public static int minusNumber(int num1, int num2)
    {
        return num1 - num2;
    }

    public static int multNumber(int num1, int num2)
    {
        return num1 * num2;
    }

    public static int devissionNumber(int num1, int num2)
    {
        return num1/num2;
    }

//    public static int askNumber(int value, String typeOf)
//    {
//        do {
//
//        }
//    }

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);


        System.out.println("Введи первую цифру: ");

        int asknum1 = ask.nextInt();

        char askOperator; // + - * /

        int asknum2 =ask.nextInt();



    }
}