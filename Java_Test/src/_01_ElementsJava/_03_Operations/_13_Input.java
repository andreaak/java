package _01_ElementsJava._03_Operations;

import java.util.Scanner;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _13_Input {
    // ќбъект класса Scanner позвол€ет обрабатывать ввод данных с консоли

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("¬ведите целое число: ");
        int a = input.nextInt();       //считываем целое число

        System.out.println("¬ведите дробное число: ");
        float b = input.nextFloat();   //считываем дробное число


        System.out.println("¬ведите строку с пробелами: ");
        String c = input.next();       //считываем строку до первого пробела

        input = new Scanner(System.in);

        System.out.println("¬ведите строку: ");
        String d = input.nextLine();   //считываем целую строку

        System.out.println(a + "\n" + b + "\n" + c + "\n" + d);
    }
}
