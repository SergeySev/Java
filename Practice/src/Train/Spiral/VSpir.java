package Train.Spiral;

import java.util.Arrays;

public class VSpir {
    public static void main(String[] args) {
        final int M = 4;
        final int N = 4;
        int[][] array = new int[M][N];
        int isVertical = 1, isRightOrDown = 1;
        int x = -1, y = 0, xSave, ySave;
        int cornerCount = 0; // выходим если счетчик поворотов установлен дважды (мы пришли в конец)
        int i = 1;
        while (cornerCount < 2) {
            xSave = x; // сохраняем координаты
            ySave = y; // сохраняем координаты
            if (isVertical == 1) {
                x += isRightOrDown;
            } else {
                y += isRightOrDown;
            }
            if (isWrongXY(x, y, M, N) && array[x][y] == 0) {
                array[x][y] = i;
                cornerCount = 0;
            } else {
                isRightOrDown = isRightOrDown * isVertical; // меняем горизонатальный порядок на обратный в нужных углах
                isVertical = -isVertical; // меняем вертикальный порядок
                x = xSave; // востанавливаем координаты
                y = ySave; // востанавливаем координаты
                cornerCount++; // увеличиваем счетчик поворотов (если он равен 2 мы пришли в конечную точку)
            }
            i++;
        }
//        System.out.println(Arrays.deepToString(array));
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static boolean isWrongXY(int x, int y, int M, int N) {
        return x < M && y < N && x > -1 && y > -1;
    }
}
