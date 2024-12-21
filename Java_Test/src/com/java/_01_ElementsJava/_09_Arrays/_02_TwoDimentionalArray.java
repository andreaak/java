package com.java._01_ElementsJava._09_Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _02_TwoDimentionalArray {
    // Массивы (двумерный массив).

	@Test
	public void Tst1() {
        int[][] array = new int[3][3];

        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;

        array[1][0] = 4;
        array[1][1] = 5;
        array[1][2] = 6;

        array[2][0] = 7;
        array[2][1] = 8;
        array[2][2] = 9;

        System.out.print(array[0][0]);
        System.out.print(array[0][1]);
        System.out.print(array[0][2]);
        System.out.print("\n");
        System.out.print(array[1][0]);
        System.out.print(array[1][1]);
        System.out.print(array[1][2]);
        System.out.print("\n");
        System.out.print(array[2][0]);
        System.out.print(array[2][1]);
        System.out.print(array[2][2]);
    }
	
	@Test
	public void Tst2Fill() {
        int sizeI = 3;
        int sizeJ = 3;
        int[][] array = new int[sizeI][sizeJ];

        // Заполнение массива
        for (int i = 0; i < sizeI; i++) {
            for (int j = 0; j < sizeJ; j++) {
                array[i][j] = i * j + 1;
            }
        }

        for (int i = 0; i < sizeI; i++) {
            for (int j = 0; j < sizeJ; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.print("\n");
        }
    }
	
	@Test
	public void Tst3Fill() {
        // Компилятор определяет размер массива на основании выражения инициализации.
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(array);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.print("\n");
        }
    }
	
    // Массивы состоящие из одного элемента.

	@Test
	public void Tst4OneElement() {
        int[] vector = new int[1];
        vector[0] = 100;
        System.out.println(vector[0]);

        int[][] matrix = new int[1][1];
        matrix[0][0] = 200;
        System.out.println(matrix[0][0]);
    }
}
