package _01_ElementsJava._01_Types;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _03_DefaultValues {
	
	@Test
	public void Tst() {
        // создаем переменную с именем a, типа byte и не присваиваем ей никакого значения.

        byte a;
        boolean b;
        char c;
        String s;

        // ОШИБКА: Запрещается использование неинициализированной локальной переменной!
        //System.out.println(a);
    }
}
