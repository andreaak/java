package com.java._01_ElementsJava._03_Operations;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Scanner;

@RunWith(JUnit4.class)
public class _13_Input {
    // ������ ������ Scanner ��������� ������������ ���� ������ � �������

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("������� ����� �����: ");
        int a = input.nextInt();       //��������� ����� �����

        System.out.println("������� ������� �����: ");
        float b = input.nextFloat();   //��������� ������� �����


        System.out.println("������� ������ � ���������: ");
        String c = input.next();       //��������� ������ �� ������� �������

        input = new Scanner(System.in);

        System.out.println("������� ������: ");
        String d = input.nextLine();   //��������� ����� ������

        System.out.println(a + "\n" + b + "\n" + c + "\n" + d);
    }
}
