package com.java._01_ElementsJava._09_Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;// методы класса Arrays

import java.util.Arrays;


public class _06_ArraysMethods {

    @Test
    public void Tst1() {
        int[] arr = {2, 12, 3, 124, 55, 22};
        int[] arr2 = {56, 78, 23};

        // через метод toString выводим его содержимое
        System.out.println(Arrays.toString(arr));
        // Сортировка массива
        Arrays.sort(arr);
        // через метод toString выводим его содержимое
        System.out.println(Arrays.toString(arr));

        // вывод массива(выводит место в памяти,
        // которое занимает массив)
        System.out.println(arr);

        // поиск элемента в массиве
        System.out.println(Arrays.binarySearch(arr, 12));

        // сравнивает массивы
        System.out.println(Arrays.equals(arr, arr2));

        // вставить элемент в массив
        Arrays.fill(arr, 12);
        System.out.println(Arrays.toString(arr));

        /*
        [2, 12, 3, 124, 55, 22]
        [2, 3, 12, 22, 55, 124]
        [I@1b0375b3
        2
        false
        [12, 12, 12, 12, 12, 12]
         */
    }
}