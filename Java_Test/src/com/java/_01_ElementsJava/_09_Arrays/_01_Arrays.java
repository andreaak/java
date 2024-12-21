package com.java._01_ElementsJava._09_Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _01_Arrays {
    // Массивы (одномерный массив).

	@Test
	public void Tst1() {
        // На 9 строке создаем массив целочисленных элементов с именем array размерностью в 5 элементов

        int[] array = new int[5];

        // На 13 строке элементу массива array по индексу 0 присваиваем значение 10

        array[0] = 10;
        array[1] = 20;
        array[2] = 30;
        array[3] = 40;
        array[4] = 50;

        // На 21 строке выводим на экран значение элемента массива array по индексу 0

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
        /*
        10
        20
        30
        40
        50
         */
        // создаем массив целочисленных элементов с именем array
        // и заполняем его значениями 1,2,3,4,5

        array = new int[]{1, 2, 3, 4, 5};

        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        /*
        1
        2
        3
        4
        5
         */

        int[] array2 = {1, 2, 3, 4, 5};//Такая форма может быть использована только при объявлениии переменной
        
        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
        /*
        1
        2
        3
        4
        5
        */
    }
	
    // Массивы (одномерный массив).

	@Test
	public void Tst2Fill() {
        int[] array = new int[5];

        // Заполнение массива.
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }

        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        // Специальная запись цикла for для прохождения элементов массива (Java 8)
        // Аналогична конструкции foreach, используемой в других языках программирования (например C#, PHP)
        // for (int ключ, массив)
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        /*
        0
		2
		4
		6
		8
		0 2 4 6 8 
        */
	}
	
    // Массивы (одномерный массив).

	@Test
	public void Tst2NotInitializedArray() {
        int[] array = new int[5];

        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        /*
        0
		0
		0
		0
		0
        */
    }
	

}
