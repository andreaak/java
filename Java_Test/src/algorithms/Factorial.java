package algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Factorial {

	@Test
	public void Test()
	{
		int temp = 10;
		int factorial = factorial(temp);
		System.out.println("Factorial recursive " +  temp + " = " + factorial);
		factorial = factorial2(temp);
		System.out.println("Factorial iterative " +  temp + " = " + factorial);	
	}
	
	public int factorial(int n)
	{
		if(n <= 1)
		{
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	public int factorial2(int n)
	{
		int s = 1;
		for(int i = n; i > 0; i--)
		{
			s *= i;
		}
		return s;
	}
	
	
    // Циклическая конструкция - do-while.

    // Факториал числа n (обозначается n!, произносится - эн факториал) — это произведение всех натуральных чисел,
    // от 1 до n включительно:
    //     n! = 1 * 2 * 3 * ... * n
    //     0! = 1

    // В комбинаторике факториал натурального числа n интерпретируется как количество перестановок множества из n элементов.
    // Например, для множества {A,B,C,D} из 4-х элементов существует: 4! = 1 * 2 * 3 * 4 = 24 перестановки:

    //     ABCD  BACD  CABD  DABC
    //     ABDC  BADC  CADB  DACB
    //     ACBD  BCAD  CBAD  DBAC
    //     ACDB  BCDA  CBDA  DBCA
    //     ADBC  BDAC  CDAB  DCAB
    //     ADCB  BDCA  CDBA  DCBA

	@Test
	public void Test2() {
		
        int counter = 4;
        int factorial = 1;

        System.out.print("Факториал числа: " + counter + "! = ");

        do {
            // Сначала умножение, потом декремент.
            factorial *= counter--;

            // Данная строка эквивалентна:

            //factorial = factorial * counter;
            //counter = counter - 1;
        }
        while (counter > 0);

        System.out.print(factorial);
    }
}
