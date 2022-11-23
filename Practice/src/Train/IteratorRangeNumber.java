package Train;

import java.util.NoSuchElementException;

public class IteratorRangeNumber {
    public static void main(String[] args) {
        for (int i :
                Range.fromTo(2, 8)) {
            System.out.println(i);
        }
    }


    private static class Range implements Iterable<Integer> {
        int from;
        int to;
        public static Integer[] fromTo(int from, int to) {
            Integer[] fromTo = new Integer[to-from];
            for (int i = from, j = 0; i < to; i++, j++){
                fromTo[j] = i;
            }
            return fromTo;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>(fromTo(from, to));
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

