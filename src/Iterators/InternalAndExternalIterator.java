package Iterators;

import java.util.Arrays;
import java.util.List;

public class InternalAndExternalIterator {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // external 1
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        // external 2
        for (Integer i : numbers) {
            System.out.println(i);
        }

        // internal
        numbers.forEach(System.out::println);

    }

}

