package Train;

import java.util.Arrays;

public class LeftShift {

    public static int[] leftShift(int[] originArray, int shift) {
        /*
         * Function shift array to number shift.
         * leftShift({{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 1) -> [11, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         * leftShift({{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 4) -> [8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7]
         * leftShift({{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, array.length) -> [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
         * leftShift({{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, array.length - 1) -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0]
         * leftShift({{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 0) -> [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
         * */
        int[] newArray = new int[originArray.length];
        for (int i = 0, j = shift; i < newArray.length; i++) {
            if (i < shift) {
                newArray[i] = originArray[originArray.length - j];
                j--;
            } else newArray[i] = originArray[i - shift];
        }
        return newArray;
    }


    public static void main(String[] args) {
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(Arrays.toString(leftShift(number, 1)));
        System.out.println(Arrays.toString(leftShift(number, 4)));
        System.out.println(Arrays.toString(leftShift(number, number.length)));
        System.out.println(Arrays.toString(leftShift(number, number.length - 1)));
        System.out.println(Arrays.toString(leftShift(number, 0)));
    }
}
