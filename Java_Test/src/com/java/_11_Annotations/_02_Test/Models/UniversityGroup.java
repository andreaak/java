package com.java._11_Annotations._02_Test.Models;

import com.java._11_Annotations._02_Test.TestAnno;

public class UniversityGroup {
    // Тестовый метод
    @TestAnno
    public static boolean isCorrectNumberOfGroups() {
        // Тестируем нашу программу, 1 + 2 + 3 + 4 == 10
        boolean res = groupsCalculator(1, 2, 3, 4) == 10;
        System.out.println("UniversityGroupsNumber is = " + res);
        return res;
    }

    // Метод принимает массив(varArgs) long
    private static long groupsCalculator(long... numberGroups) {
        long res = 0;
        for (long tmp : numberGroups) {
            res += tmp;
        }
        return res;
    }
}
