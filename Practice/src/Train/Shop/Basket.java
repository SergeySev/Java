package Train.Shop;

import java.util.Scanner;

public class Basket {

    /*
    Вам нужно реализовать пользователь сначала вводит целое число с клавиатуры (количество товара),
    потом дробное число (цену товара), после этого результат вы умножаете на 120% (добавляете VAT),
    округляете до целых с округлением вверх (то есть всегда к большему),
    сохраняете в Integer и уже выводите на экран.
Подсказка: можно использовать класс Scanner и методы scanner.nextInt(), scanner.nextDouble() для ввода чисел
и Math.round

1. Пользователь вводит целое число с клавиатуры - количество товара.✅
2. Пользователь вводит дробное число (цену товара)✅
3. Добавить 20% VAT✅
4. Округляем до целого числа вверх.✅
5. Сохраняем результат округления в Integer.✅
6. Выводим на экран.✅
     */

    static int addVat(float productsPrice) {
        return (int) Math.ceil(productsPrice + (productsPrice * 0.2f));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many products do you want to buy?");
        byte quantityProducts = scanner.nextByte();

        System.out.println("Please, enter the product/s price:");
        float productsPrice = scanner.nextFloat();

        productsPrice = productsPrice * quantityProducts;
        System.out.println(addVat(productsPrice));
    }
}
