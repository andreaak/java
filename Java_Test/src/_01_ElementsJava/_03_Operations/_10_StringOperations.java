package _01_ElementsJava._03_Operations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _10_StringOperations {
	
    // Сцепление строк. (Конкатенация)
	@Test
	public void TstConcat() {
        // 1 вариант.
        String word1 = "Привет ";
        String word2 = "Мир!";
        String phrase = word1 + word2;
        System.out.println(phrase);

        // 2 вариант.
        System.out.println("Hello " + "World!");
    }
	
	@Test
	public void TstFormat() {
        int a = 1, b = 2, c = 3;

        // Конкатенация строк
        System.out.println("Это число " + a);

        // Форматирование строк с помощью метода format класса String
        System.out.println(String.format("Это число %1$s", a));

        // Метод printf() принадлежит классу PrintStream, который отвечает за вывод информации
        // и возвращает строку, отформатированую по заданным условиям
        System.out.printf("Это число %1$s \n", a);
        System.out.printf("Это числа %1$s и %2$s \n", b, c);
        System.out.printf("Это числа наоборот %2$s и %1$s", b, c);
        // Форматирование вывода числа Пи
        System.out.printf("\n%1$+022.10f", Math.PI);
    }
}


