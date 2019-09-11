package Iterators;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FromIteratorToMethodReference {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer value) {
                System.out.println(value);
            }
        });

//        replace noise

        numbers.forEach((Integer value) -> System.out.println(value));

//        no puppy in a collection of integers

        numbers.forEach(value -> System.out.println(value));

//        just a pass through

        numbers.forEach(System.out::println);


//

        numbers.forEach(e -> System.out.println(e));
        numbers.forEach(System.out::println);

        numbers.stream()
                .map(e -> Integer.toString(e))
                .forEach(System.out::println);

//again


//
//        numbers.stream()
//                .map(Integer::toString)
//                .forEach(System.out::println);

        // this complains - why? https://engineering.shoutapp.io/a-tale-of-method-reference-ambiguity-e51d3c5d9b00
//        numbers.stream()
//                .map(Integer::toString)
//                .forEach(System.out::println);

// e is an argument
        numbers.stream()
                .map(Integer::valueOf)
                .forEach(System.out::println);


        // e as target
        numbers.stream()
                .map(e -> e.toString())
                .forEach(System.out::println);

        // more paramters

        // sum them all

        System.out.println(
                numbers.stream().reduce(0,(total,e)->Integer.sum(total,e))
        );

        // sum is nice, it does not care but you must not change the methd reference

        System.out.println(
                numbers.stream().reduce(0,Integer::sum)
        );


        System.out.println(
                numbers.stream().map(String::valueOf)
                        .reduce("",(carry,str)->carry.concat(str)) // order makes a difference
        );

        System.out.println("this wirks as well");
        // first parameter is a target second is an argument / i can still use mehtod references
        System.out.println(
                numbers.stream().map(String::valueOf)
                        .reduce("",String::concat)
        );

// limits
        // not possible if ther is conflict instance method static method - Integer.tostring
        // you cannot use them if you are doing manipulation with data


// https://developer.ibm.com/articles/j-java8idioms6
        // lambdas are glue code    http://blog.agiledeveloper.com/2015/06/lambdas-are-glue-code.html
// rather write a function
//        numbers.forEach(value -> {
//            System.out.println("Lambdas");
//            System.out.println("should");
//            System.out.println("not");
//            System.out.println("have");
//            System.out.println("more");
//            System.out.println("than");
//            System.out.println("one");
//            System.out.println("line");
//        });


    }

}
