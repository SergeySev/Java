package Train.Spiral;

import java.util.Arrays;

public class Spiral {

    public static int[][] spiral(int width, int height) {
        int[][] array = new int[height][width];

        int fillNumber = 1;
        int lastNumber = (width * height + 1);

        int fillright = 0;
        int fillleft = width - 1;
        int fillcolumn = height - 1;

        while (fillNumber != lastNumber) {
            if (width == height && fillNumber == lastNumber - 1 && width % 2 != 0) {
                array[fillright][fillright] = width * height;
                return array;
            }
            for (int i = fillright; i < fillleft; i++) { // fill right
                if (fillNumber == lastNumber) {
                    return array;
                }
                array[fillright][i] = fillNumber;
                fillNumber++;
            }

            for (int i = fillright; i < fillcolumn; i++) { // fill down
                if (fillNumber == lastNumber) {
                    return array;
                }
                array[i][fillleft] = fillNumber;
                fillNumber++;
            }
            for (int i = fillleft; i > fillright; i--) { // fill left
                if (fillNumber == lastNumber) {
                    return array;
                }
                array[fillcolumn][i] = fillNumber;
                fillNumber++;
            }
            for (int i = fillcolumn; i > fillright; i--) { // fill up
                if (fillNumber == lastNumber) {
                    return array;
                }
                array[i][fillright] = fillNumber;
                fillNumber++;
            }
            fillright++;
            fillleft--;
            fillcolumn--;
        }
        return array;
    }

    public static void getArray(int width, int height) {
        for (int s = 0; s < height; s++) {
            System.out.println(Arrays.toString(spiral(width, height)[s]));
        }
    }

    public static void testSergey() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                try {
                    getArray(j, i);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("ERROR WITH I = " + i + " J = " + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        testSergey();
    }
}
