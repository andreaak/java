package _01_ElementsJava._02_Variables;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _03_LocalVariables {
    // ������������� ��������� �������� � ��������� ����������.

	@Test
	public void Tst() {
        // �������:
        // � ���� ����� ��������� ��������� ������� � � ���� ������ ��������� �������� ������� ����������� ����������.

        // ��������� ������� 1
        {
            int a = 1;
            System.out.println(a);
        }

        // System.out.println(a); - ������: ���������� ��������� � ��������� ������� � �� ���������� �� � ���������.

        // ��������� ������� 2
        {
            int a = 2;
            System.out.println(a);
        }

        int a = 3;
        System.out.println(a);
    }
}
