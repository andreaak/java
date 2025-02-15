package com.java._16_StreamAPI._02_Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class _02_PrimitivesTest {
    @Test
    public void TestStreamAPI1Optional(){
        int[] numbers = getInts();
        OptionalInt optionalMax = Arrays.stream(numbers).max();
        if (optionalMax.isPresent()) {
            int max = optionalMax.getAsInt();
            System.out.println("Max: " + max);
        } else {
            System.out.println("Not found max value!");
        }

        int min = Arrays.stream(numbers).min().orElse(0);
        System.out.println("Min: " + min);

        OptionalDouble optionalAverage = Arrays.stream(numbers).average();
        optionalAverage.ifPresent(value -> System.out.println("Average: " + value));

        int sum = Arrays.stream(numbers).reduce(0, _02_PrimitivesTest::calcSum);
        System.out.println("Sum: "+ sum);

        int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println("Sum2: "+ sum2);

        /*
        Max: 12
        Min: 2
        Average: 7.0
        a=0 b=2
        a=2 b=4
        a=6 b=6
        a=12 b=12
        a=24 b=7
        a=31 b=8
        a=39 b=10
        Sum: 49
        Sum2: 49
         */
    }

    private static int[] getInts() {
        int[] numbers = {2, 4, 6, 12, 7, 8, 10};
        return numbers;
    }

    public static int calcSum(int a, int b) {
        System.out.println("a="+ a + " b="+ b);
        return a + b;
    }
}
