package _01_ElementsJava._03_Operations;

import static java.lang.Math.pow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _02_Arithmetic {

    // Арифметические операторы (C03_Arithmetic Operators): +, -, *, /, %

	@Test
	public void Tst() {
        // Addition (+)
        byte summand1 = 1, summand2 = 2; // Множественное объявление.
        int sum = 0;
        sum = summand1 + summand2;

        System.out.println(sum);

        // Subtraction (-)
        byte minuend = 5, subtrahend = 3;
        int difference = 0;
        difference = minuend - subtrahend;

        System.out.println(difference);

        // Multiplication (*)
        byte factor1 = 2, factor2 = 3;
        int product = 0;
        product = factor1 * factor2;

        System.out.println(product);

        // Division (/)
        byte dividend = 5, divisor = 2;
        int quotient = 0, remainder = 0;
        quotient = dividend / divisor;

        System.out.println(quotient);

        // Remainder after division (%)
        remainder = dividend % divisor;

        System.out.println(remainder);
    }
	
	@Test
	public void TstIncDec() {
        System.out.println("----- Постфиксный инкремент"); // Post-increment

        byte number1 = 0;
        System.out.println(number1++); // Сначала выводим на экран, потом увеличиваем на 1.
        System.out.println(number1);

        System.out.println("----- Префиксный инкремент"); // Pre-increment

        byte number2 = 0;
        System.out.println(++number2); // Сначала увеличиваем на 1, потом выводим на экран.

        System.out.println("----- Постфиксный декремент"); // Post-decrement

        byte number3 = 0;
        System.out.println(number3--); // Сначала выводим на экран, потом уменьшаем на 1.
        System.out.println(number3);

        System.out.println("----- Префиксный декремент"); // Pre-decrement

        byte number4 = 0;
        System.out.println(--number4); // Сначала уменьшаем на 1, потом выводим на экран.
        int i = 0;

        i = i + 1;  i += 1;
        i = i + 5;  i += 5;

        i = i - 10;  i -= 10;
    }
	
    /* Math.pow() - возведение числа в степень
     * 1-ый аргумент - число, которое возводим в степень,
     * 2-ой – показатель степени, в которую возводим число.
     */

	@Test
	public void TstPow() {
        double x = 2, y = 8;

        double result = pow(x, y);

        System.out.println(result);
    }
    
    // Math.sqrt() - математическая функция, которая извлекает квадратный корень

	@Test
	public void TstSqrt() {
        double x = 256;

        double result = Math.sqrt(x);

        System.out.println("Квадратный корень: " + result);
    }
}
