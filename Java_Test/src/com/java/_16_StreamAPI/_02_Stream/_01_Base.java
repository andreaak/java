package com.java._16_StreamAPI._02_Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _01_Base {
    @Test
    public void TestStreamAPI1Source() {
        List<Integer> collect = Arrays.asList(10, -20, 30, 40, 30)
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

        Stream<Integer> stream = Stream.of(10, 20, 30);

        String[] arr = {"Yevhenii", "Karyna", "Marsel"};

        Stream<String> stream1 = Arrays.stream(arr);

        Stream<Object> build = Stream.builder()
                .add(10)
                .add(20)
                .add(30)
                .build();

        IntStream chars = "Hello".chars();
        /*
            konveer:
                map, filter, distinct, parallel, sequential, flatMap, skip, limit

            terminal:
                forEach, collect, min/max/sum/count, matcher(anyMatch, allMatch),
                findFirst, findAny, iterator
         */
    }

    @Test
    public void TestStreamAPI2Optional() {
        Optional<Integer> opt1 = Optional.empty();
        Optional<Integer> opt2 = Optional.of(10);
        Optional<Integer> opt3 = Optional.ofNullable(null);
        System.out.println(opt1);
        System.out.println(opt2);
        System.out.println(opt3);

        /*
        Optional.empty
        Optional[10]
        Optional.empty
         */

        String str;
        if (getString(true).isPresent()) {
            //str = getString().get();
            str = getString(false).orElseGet(String::new);
            System.out.println(str);
            /*

             */
        }

        str = getString(false).orElse(null);
        System.out.println(str);
        /*
        null
         */
        try {
            str = getString(false).orElseThrow();
        } catch (Exception e) {
            System.out.println(e);
        }
        /*
            java.util.NoSuchElementException: No value present
        */

        Stream.of(str).forEach(System.out::println);
        /*
        null
         */

        Objects.isNull("Test");
    }



    public static Optional<String> getString(boolean res) {
        if (res) {
            return Optional.of("Simple value");
        }
        return Optional.empty();
    }
}
