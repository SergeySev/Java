package Train;

import java.util.Arrays;

public class LeftShift {

    public static int[] leftShift(int[] originArray, int shift) {
        // сначала отнимает shift от длины до -1 // а потом заполняет с 0 до array - shift
        int[] newArray = originArray.clone();
        for (int i = 0; i < newArray.length - shift; i++) {
            newArray[i + shift] = originArray[i];
        }
        for (int i = 0, j = shift; i < shift; i++, j--) {
            newArray[i] = originArray[originArray.length - j];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int k = 3;
        int[] number1 = {9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(Arrays.toString(leftShift(number, 3)));

    }
}
