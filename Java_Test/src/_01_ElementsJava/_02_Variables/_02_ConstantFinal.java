package _01_ElementsJava._02_Variables;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _02_ConstantFinal {
	
	/*
	Константа –это именованная область памяти, которая хранит в себе некоторое значение, которое нельзя изменить.
	*/
	
	@Test
	public void Tst() {
        // На 7-й строке, создаем константу с именем pi, типа double и присваиваем ей значение 3.141

        final double PI = 3.1415;

        // На 11-й строке, выводим значение константы - pi, на экран.

        System.out.println("Значение числа Пи в мирное время равно: " + PI + " в лучшие годы");

        // Попытка присвоения константе нового значения, приводит к ошибке уровня компиляции!

        // PI = 2.71828183;
    }
}

