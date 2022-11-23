package Train;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IteratorRange {
    public static void main(String[] args) {

        Integer[] test = {1, 2, 3, 4, 5, 6};
        Range range = new Range(test);
        Iterator<Integer> my = range.iterator();
        System.out.println(my.hasNext());
        System.out.println(my.next());
        System.out.println(my.next());
        System.out.println(my.next());
        System.out.println(Arrays.toString(range.fromTo(0, 5)));

        for (int i :
                range.fromTo(2, 6)) {
            System.out.println(i);
        }
    }


    private static class Range implements Iterable<Integer> {
         Integer[] arrayInt;
        public  Integer[] fromTo(int from, int to) {
            Integer[] fromTo = new Integer[to-from];
            for (int i = from, j = 0; i < to; i++, j++){
                fromTo[j] = arrayInt[i];
            }
            return fromTo;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>(arrayInt);
        }

        public Range(Integer[] arrayInt) {
            this.arrayInt = arrayInt;
        }
    }
    static class Iterator<I extends Number> implements java.util.Iterator<Integer> {
        private final Integer[] array;
        private int point = 0;

        public Iterator(Integer[] array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return point < array.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[point++];
        }
    }
}

