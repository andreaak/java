package _01_ElementsJava._05_Branches;

import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _02_Ternary {
    // Тернарная условная операция.

    // Тернарный (троичный) оператор [?:] .
    // Тернарный оператор [?:], является сокращенной формой конструкции if ... else.
    // [?:] - включает в себя три операнда - ( условие ? Если условие ИСТИННО : Если условие ЛОЖНО )

    // Алгоритм работы тернарной операции: (логическое выражение) ? выражение 1 : выражение 2
    //    1. Вычисляется логическое выражение (условие).
    //    2. Если логическое выражение истинно, то вычисляется значение выражения выражение 1, в противном случае - значение выражения выражение 2.
    //    3. Вычисленное значение возвращается.

	@Test
	public void TstTernary() {
        int a = 1, b = 2, max = 0;

        // Переменной max, присваиваем возвращаемое значение тернарного оператора.

        max = (a > b) ? a : b;   // ЕСЛИ:  (a > b)  ТО:  вернуть a  ИНАЧЕ: вернуть b;
        System.out.println(max);
    }
	
    // Тернарная условная операция.
	@Test
	public void TstTernary2() {
        int a = 1, b = 2, c = -5, max = 0;

        max = a > b ? (c = a) : (c = b); // сначала с = а, а только потом max = c
        System.out.println(max);
    }
	
	@Test
	public void TstTernary3() {
        String string = "Hello ";

        System.out.println("Введите свой логин:");
        Scanner in = new Scanner(System.in);
        // На 14 строке создаем переменную с именем login типа String и принимаем в нее ввод от пользователя

        String login = in.next();

        // На 18 строке переменной string присваиваем возвращаемое значение тернарного оператора

        string += login.equals("Admin") ? "Administrator" : "User";
        System.out.println(string);
    }
	
    // Тернарная условная операция. Ограничения связанные с типобезопасностью.
	@Test
	public void TstTernary4TypeCast() {
        int a = 1;
        double b = 0.0;
        int max;

        // Выражения [?] и [:]  - должны быть одного типа.

        max = (int)((a > b) ? a : b);

        // ... или так

        max = (a > b) ? a : (int)b;

        System.out.println(max);
    }
	
    //Вложенные тернарные операторы.
	@Test
	public void TstTernary5InnerOperator() {
        // Определение квадранта в котором лежит заданная точка.
        // Для упрощения примера условимся, что точка не будет лежать в центре координат и на координатных осях,
        // это значит, что x и y - не могут быть равны 0.

        int x = 10, y = -5;
        String quadrant0, quadrant1,quadrant2;


        // Не рекомендуется вкладывать тернарные операторы, так как это ухудшает чтение кода.

        //                   condition    true block    false block     condition   true block       false block
        //                    -------- ? ------------ : -------------    -------- ? ------------- : --------------
        quadrant0 = (x > 0) ? ((y > 0) ? "I квадрант" : "IV квадрант") : ((y > 0) ? "II квадрант" : "III квадрант");
        //          ------- ? ---------------------------------------- : -------------------------------------------
        //         condition               true block                                   false block

        // ... или так

        quadrant1 = x > 0 ? (y > 0 ? "I квадрант" : "IV квадрант") : (y > 0 ? "II квадрант" : "III квадрант");

        // ... или вообще, вот так

        quadrant2 = x > 0 ? y > 0 ? "I квадрант" : "IV квадрант" : y > 0 ? "II квадрант" : "III квадрант";

        System.out.println(quadrant0);
        System.out.println(quadrant1);
        System.out.println(quadrant2);
    }
}
