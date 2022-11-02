package Train.Spiral;

import java.util.Arrays;

public class SpiralOneCycle {
    static int[][] spiralOneCycle(int width) {
        int[][] array = new int[width][width];

        int fillNumber = 1;
        int lastNumber = (width * width) + 1;

        int fillright = 0;
        int fillleftDown = width - 1;  // - если это квадрат, то это же равно и высота
//            int fillcolumn = height - 1;

//        boolean goRight = true;
//        boolean goDown = true;
//        boolean goLeft = true;
//        boolean goUp = true;

//        boolean[] direction = {goRight, goDown, goLeft, goUp};

        while (fillNumber != lastNumber) {
            boolean[] direction = {true, true, true, true};

            for (int j = 0; j < direction.length; j++) {

                for (int i = direction[1] ? fillright : fillleftDown; i < (direction[1] ? fillleftDown : fillright); ) {

                    if (direction[0]) {
                        array[fillright][i] = fillNumber;
                        fillNumber++;
                    } else if (direction[1]) {
                        array[i][fillleftDown] = fillNumber;
                        fillNumber++;
                    } else if (direction[2]) {
                        array[fillleftDown][i] = fillNumber;
                        fillNumber++;
                    } else if (direction[3]) {
                        array[i][fillright] = fillNumber;
                        fillNumber++;
                    }
                    if (direction[1]) {i++;} else i--;
                }
                direction[j] = !direction[j];
//                if (j == 1) {
//                    direction[0] = !direction[0];
//                    direction[1] = !direction[1];
//                    direction[2] = !direction[2];
//                    direction[3] = !direction[3];
//                }
//                direction[j] = !direction[j];
//                if (j == 3) {
//                    direction[0] = !direction[0];
//                } else {
//                    direction[j + 1] = !direction[j + 1];
//                }
            }
            fillright++;
            fillleftDown--;
        }
        return array;
    }

    public static void getArray(int width) {
        for (int s = 0; s < width; s++) {
            System.out.println(Arrays.toString(spiralOneCycle(width)[s]));
        }
    }

    public static void main(String[] args) {
        getArray(4);
    }
}
