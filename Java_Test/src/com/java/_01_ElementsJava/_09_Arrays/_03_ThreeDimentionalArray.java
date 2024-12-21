package com.java._01_ElementsJava._09_Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _03_ThreeDimentionalArray {
    // Массивы (трехмерный массив).

	@Test
	public void Tst1() {
        int[][][] array = new int[3][3][3];

        array[0][0][0] = 1;
        array[0][0][1] = 2;
        array[0][0][2] = 3;
        array[0][1][0] = 4;
        array[0][1][1] = 5;
        array[0][1][2] = 6;
        array[0][2][0] = 7;
        array[0][2][1] = 8;
        array[0][2][2] = 9;

        array[1][0][0] = 1;
        array[1][0][1] = 2;
        array[1][0][2] = 3;
        array[1][1][0] = 4;
        array[1][1][1] = 5;
        array[1][1][2] = 6;
        array[1][2][0] = 7;
        array[1][2][1] = 8;
        array[1][2][2] = 9;

        array[2][0][0] = 1;
        array[2][0][1] = 2;
        array[2][0][2] = 3;
        array[2][1][0] = 4;
        array[2][1][1] = 5;
        array[2][1][2] = 6;
        array[2][2][0] = 7;
        array[2][2][1] = 8;
        array[2][2][2] = 9;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }
	
	@Test
	public void Tst2Fill() {
        int[][][] array = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }
        };
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }
}
