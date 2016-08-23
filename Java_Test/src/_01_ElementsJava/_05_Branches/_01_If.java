package _01_ElementsJava._05_Branches;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _01_If {
    
	@Test
	public void TstIf() {
        int a = 1, b = 2; // создаем две целочисленные переменные

        // На 9-й строке создаем условную конструкцию if, в условии которой проверяем: a меньше b

        if (a < b) {     // Если условие удовлетворяет истинности, выполняем тело условной конструкции.
            System.out.println("a < b");     // Ветвь 1
        }
    }
	
	@Test
	public void TstIfElse() {
        int a = 1, b = 2; // создаем две целочисленные переменные

        // На 9-й строке создаем условную конструкцию if, в условии которой проверяем: a меньше b

        if (a < b) {     // Если условие удовлетворяет истинности, выполняем тело условной конструкции.
            System.out.println("a < b");     // Ветвь 1
        }
    }
	
	@Test
	public void TstIfElseShort() {
        int a = 1, b = 2;

        // Если тело блока if или else состоит из одного выражения, то операторные скобки можно опустить

        if (a < b)
            System.out.println("a меньше b");      // Ветвь 1
        else
            System.out.println("a не меньше b");   // Ветвь 2
    }
}
