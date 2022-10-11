import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader bufferedReader = new BufferedReader(reader);

    public static void sumNumber(int num1, int num2) {
        System.out.println(num1 + num2);
    }


    public static void minusNumber(int num1, int num2) {
        System.out.println(num1 - num2);
    }

    public static void multNumber(int num1, int num2) {
        System.out.println(num1 * num2);
    }

    public static void divisionNumber(int num1, int num2) {
        try {
            System.out.println(num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println("Dividing by zero is forbidden");
        }

    }

    public static void squareNumber(int num1, int num2) {
        int result = 1;
        for (int i = 0; i < num2; i++) {
            result = result * num1;
        }
        System.out.println(result);
    }


    public static int askNumber() throws IOException {
        boolean getnumber = false;
        int asknum1 = 0;

        do {
            try {
                asknum1 = Integer.parseInt(bufferedReader.readLine());
                getnumber = true;
            } catch (NumberFormatException e) {
                System.out.println("You input not a number. Please, input the number:");
            }
        } while (!getnumber);

        return asknum1;
    }

    public static void runProgram() throws IOException {

        System.out.println("Input the first number: ");
        int asknum1 = askNumber();

        System.out.println("Input the math operation (+, -, *, /, ^ : ");
        String askOperator = bufferedReader.readLine();

        System.out.println("Input the second number: ");
        int asknum2 = askNumber();

        switch (askOperator) {
            case "+" -> sumNumber(asknum1, asknum2);
            case "-" -> minusNumber(asknum1, asknum2);
            case "*" -> multNumber(asknum1, asknum2);
            case "/" -> divisionNumber(asknum1, asknum2);
            case "^" -> squareNumber(asknum1, asknum2);
        }
    }

    public static void main(String[] args) throws IOException {
        String runAgain = "";
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            runProgram();
            System.out.println("Would you like to continue?" +
                    "\nInput \"y\" - to continue" +
                    "\nInput \"n\" to end the program");
            runAgain = bufferedReader.readLine();

            if (runAgain.equals("y")) {
                continue;
            } else if (runAgain.equals("n")) {
                break;
            }
        }
        bufferedReader.close();
        reader.close();
    }
}