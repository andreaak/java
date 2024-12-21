package com.java._01_ElementsJava._05_Branches;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Scanner;

@RunWith(JUnit4.class)
public class _03_Switch {

    // Оператор многозначного выбора - switch-case (переключатель).
    @Test
    public void TstSwitchString() {
        // Предлагаем пользователю ввести число.
        System.out.println("Введите число 1 или 2: ");

        // Принимаем ввод от пользователя.
        Scanner in = new Scanner(System.in);
        String number = in.next();

        // На 19 строке создаем конструкцию многозначного выбора, переключатель - switch,
        // которому в качестве выражения-селектора, передаем переменную - number.

        switch (number) { // (number) - выражение-селектор.

            // В теле переключателя switch-case, на 27 и 32 строках,
            // создаем два оператора case, c постоянными выражениями равными "1" и "2" соответственно.

            // Если значение выражения-селектора совпадет с одним из значений постоянных выражений,
            // то выполняется тело оператора case, постоянное выражение которого, совпало с выражением-селектора.

            case "1": {   // "1" - постоянное выражение.
                System.out.println("Один");                                       // Ветвь 1
                // Выход из переключателя.
                break;
            }
            case "2": {
                System.out.println("Два");                                        // Ветвь 2
                break;
            }

            // На 40 строке создаем (необязательный) оператор default, тело которого выполняется в случае,
            // если значение выражения-селектора не совпадет ни с одним из значений постоянных выражений.

            default: {
                System.out.println("Вы ввели значение отличное от 1 и 2.");       // Ветвь 3
                break;
            }

            // Если в переключателе отсутствует оператор default, то управление передается за пределы переключателя switch.
        }
    }

    @Test
    public void TstSwitch2Int() {
        int myDay;
        System.out.println("Введите номер дня недели: 1-2-3-4-5-6-7: ");
        Scanner in = new Scanner(System.in);
        myDay = in.nextInt();

        // Конвертируем значение строковой переменной myDay в целочисленное значение
        // и записываем его в переменную с именем myDay типа int

        switch (myDay) {
            case 1:
                System.out.println("Понедельник.");
                break;
            case 2:
                System.out.println("Вторник.");
                break;
            case 3:
                System.out.println("Среда.");
                break;
            case 4:
                System.out.println("Четверг.");
                break;
            case 5:
                System.out.println("Пятница.");
                break;
            case 6:
                System.out.println("Суббота.");
                break;
            case 7:
                System.out.println("Воскресенье.");
                break;
            default:
                System.out.println("Вы ввели несуществующий день недели.");
                break;
        }
    }

    //Проваливание.
    @Test
    public void TstSwitch3() {
        System.out.println("Введите номер дня недели: 1-2-3-4-5-6-7: ");
        Scanner in = new Scanner(System.in);
        String day = in.next();

        switch (day) {
            // Для пустых операторов case разрешено "проваливание" от одного оператора к другому.
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                System.out.println("Этот день недели - Рабочий.");
                break;
            case "6":
            case "7":
                System.out.println("Этот день недели - Выходной.");
                break;

            default:
                System.out.println("Вы ввели несуществующий день недели.");
                break;
        }
    }
}
