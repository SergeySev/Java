package Train;

import java.util.Arrays;
import java.util.Random;

// Заменить каждый элемент массива с нечетным индексом на ноль
//Задание:
//1. Создайте массив из 8 случайных целых чисел из интервала [1;10]
//2. Отобразить массив на экране в виде строки
//3. Замените каждый элемент с нечетным индексом на ноль.
//4. Снова отобразите массив на отдельной строке
public class TestsTask {
    public static void arrRes(int arrayLength) {
        Random random = new Random();
        int[] newArray = new int[arrayLength];
        // {0, 0, 0, 0, 0, 0, 0} - new array
        // [2, 8, 2, 6, 1, 3, 8} - origin array
        // {0, 1, 2, 3, 4, 5, 6} - index
//        for (int i = 0; i < originArray.length; i++) { // deep copy
//            newArray[i] = originArray[i];
//        }
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = random.nextInt(1,11);
        }
        System.out.println(Arrays.toString(newArray));
        int i = 0;
        while (i < newArray.length) {
            if (i % 2 != 0) {
                newArray[i] = 0;
            }
            i++;
        }
        System.out.println(Arrays.toString(newArray));
    }

    public static void main(String[] args) {
//        int[] originMassiv = new int[10];
//        Objects[] objects = new Objects[10];
//        System.out.println("Object " + Arrays.toString(objects));
//        System.out.println("Link to originMassiv: " + originMassiv);
//
//        int[] newMassiv = originMassiv;
//
//        System.out.println("Link to newMassiv: " + newMassiv);
//
//        System.out.println("Compare origin massiv with newMassiv :" +  (originMassiv == newMassiv));
//
//        int[] deepCopy = originMassiv.clone();
//        System.out.println("Link to DeepCopy: " + deepCopy);
//
//        System.out.println("Origin " + Arrays.toString(originMassiv));
//        System.out.println("Deep copy " + Arrays.toString(deepCopy));
//
//        System.out.println("Compare origin massiv with deepCopy :" +  (originMassiv == deepCopy));
//
//        System.out.println("Origin array before " + Arrays.toString(originMassiv));
        arrRes(8);
//        System.out.println("Origin array after: " + Arrays.toString(originMassiv));
    }
}
