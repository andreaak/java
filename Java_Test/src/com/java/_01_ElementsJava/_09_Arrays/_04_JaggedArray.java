package com.java._01_ElementsJava._09_Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _04_JaggedArray {
    // Зубчатые массивы (Jagged Array).

	@Test
	public void Tst1() {
        int[][] jagged = new int[3][];

        jagged[0] = new int[]{1, 2};
        jagged[1] = new int[]{1, 2, 3, 4, 5};
        jagged[2] = new int[]{1, 2, 3};

        // Во внешнем цикле выполняется проход по всем вложенным массивам.
        for (int i = 0; i < jagged.length; ++i) {
            // Во внутреннем цикле выполняется обращение к каждому элементу вложенного массива.
            for (int j = 0; j < jagged[i].length; ++j) {
                System.out.print(" " + jagged[i][j]);
            }
            System.out.print("\n");
        }
    }
    
    @Test
	public void Tst2() {
        int[][] jagged = new int[][]
                {
                        new int[]{1, 2},
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{1, 2, 3}
                };

        // Во внешнем цикле выполняется проход по всем вложенным массивам.
        for (int i = 0; i < jagged.length; ++i) {
            // Во внутреннем цикле выполняется обращение к каждому элементу вложенного массива.
            for (int j = 0; j < jagged[i].length; ++j) {
                System.out.print(" " + jagged[i][j]);
            }
            System.out.print("\n");
        }
    }
}
