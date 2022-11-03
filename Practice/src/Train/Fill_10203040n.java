package Train;

import java.util.Arrays;
import java.util.Random;

public class Fill_10203040n {
    static int[] fillMassive(int[] array) {
        Random random = new Random(); //Импортируем класс Random
        int index = 0; // переменная для заполнения конкретных индексов
        int quantityFill = 1; // переменная для отсчета количества заполняемых индексов

        while (index < array.length) { // пока не вышли за границы массива
            int iteration = quantityFill; // Так как переменную quantityFill изменять нельзя, то для
                                          // установления границ цикла вайл добавил новую переменную iteration
            while (iteration != 0) { // цикл будет повторяться пока iteration не достигнет 0.

                if (index >= array.length) { // так как в этом цикле мы можем выйти за границы массива,
                                            // тут стоит if, который не позволяет этого сделать
                    return array; // если вышли за границы массива, значит массив уже заполнен и его можно возвращать
                }
                array[index] = random.nextInt(1, 5); // заполняем индекс массива рендомом
                --iteration; // отнимаем iteration, чтобы она стремилась к 0 и наш цикл вайл закончился
                ++index; // шагаем по индексам вперед для заполнения последующих индексов
            }
            index+= quantityFill; // после отработки цикла вайл,
                                // Нам надо перепрыгнуть все те индексы, которые не заполняем.
            // А как нам их узнать? А количество не заполняемых индексов хранятся тоже в переменной quantityFill

            ++quantityFill;  // итерация - на первой - заполняем один, на второй заполняем два
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        System.out.println(Arrays.toString(fillMassive(array)));
    }
}
