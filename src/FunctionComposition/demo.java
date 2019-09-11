package FunctionComposition;

import java.util.Arrays;
import java.util.List;

public class demo {


    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int result = 0;

        for (int e : numbers) {
            if (e % 2 == 0) {
                result += e * 2;
            }
        }

        System.out.println(result);


        //
        // Spagghetti
        //

        System.out.println(
                numbers.stream().filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .reduce(0, Integer::sum)
        );

        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum()
        );

        // function composition aka pipeline


        /// we are using for far to often


    }
}
