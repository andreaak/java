package com.java._08_Strings._01_RegExp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Класс java util regex Pattern применяется для определения регулярных
выражений шаблонов для которых ищется соответствие в строке, файле
или другом объекте, представляющем последовательность символов
Для определения шаблона применяются специальные синтаксические конструкции
О каждом соответствии можно получить информацию с помощью класса java util regex Matcher
Класс Pattern используется для простой обработки строк
Для более сложной обработки строк используется класс Matcher

Metacharacters
\\b Позиция соответствующая границе слова
\\B Позиция, не соответствующая границе слова
\\n Соответствует символу новой строки
\\r Соответствует символу возврата каретки
\\t Соответствует символу табуляции
\\f Соответствует символу конца файла
\\d Соответствует любой десятичной цифре
\\D Соответствует любому символу, кроме десятичной цифры

\\w Соответствует любому алфавитно-цифровому символу и символу подчеркивания
\\W Соответствует всем символам, которые не попадают под определение метасимвола \w
\\s Соответствует любому пробельному символу
\\S Соответствует любому не пробельному символу

Quantifiers

? Предшествующий символ либо входит в строку один раз, либо вообще в нее не входит
* Предшествующий символ входит в строку любое число раз, в том числе и 0
+ Предшествующий символ входит в строку один и более число раз
{n} Предшествующий символ входит в строку n раз
{n,} Предшествующий символ входит в строку n и более количество раз
{n,m} Предшествующий символ входит в строку от n до m раз

Special characters

. 	Соответствует одному любому символу
[…] Соответствует одному символу из тех, что перечислены в квадратных скобках
[^…] Соответствует одному любому символу, не перечисленному в квадратных скобках
^ 	Позиция в начале строки
$ 	Позиция в конце строки
| 	Любое из разделяемых выражений
(…) Круглые скобки служат для логического объединения частей регулярного выражения
 */


public class Main {
    @Test
    public void TestRegExp1Split() {
        String str = "For the time being, Java Guardians sees the situation as status quo. " + "\"If after all this we see" +
                "no real activity or details after JavaOne, it will be very worrisome indeed,\" " +
                "Rahman said. An online petition has been posted by Java EE Guardians urging Oracle to move forward with EE or " +
                "turn the work over to others. As of Tuesday, the petition had more than 3,200 signatures. " +
                "Java EE Guardians has pondered developing enterprise-level Java improvements on its own.";
        String[] array = str.split("[.,]");
        for (String temp : array) {
            System.out.println(temp);
        }
    }

    @Test
    public void TestRegExp2() {
        // Проверка на соответствие строки шаблону
        Pattern p1 = Pattern.compile("a+y");
        Matcher m1 = p1.matcher("aaay");

        // Соответствует строка шаблону
        boolean b = m1.matches();
        System.out.println(b);

        // Поиск и выбор подстроки, заданной шаблоном
        String regex = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)?";
        String s = "адреса эл.почты:firstmail@mail.ru иsecondmail@gmail.com";

        Pattern p2 = Pattern.compile(regex);
        Matcher m2 = p2.matcher(s);
        while (m2.find()) {
            System.out.println("e-mail: " + m2.group());
        }

        // Разбивка строки на подстроки с применением шаблона в качестве разделителя
        Pattern p3 = Pattern.compile("\\d+\\s?");
        String[] words = p3.split("java1language 22 for3everyone");
        for (String word : words) {
            System.out.println(word);
        }
    }
    @Test
    public void TestRegExp3GroupsAndQuantifers() {
        // В первом случае к первой группе относятся все возможные символы,
        // но при этом остается минимальное количество символов для второй группы.
        myMatches("([a-z]*)([a-z]+)", "abdcxyz");

        // Во втором случае для первой группы выбирается наименьшее количество
        // символов, т. к. используется слабое совпадение.
        myMatches("([a-z]?)([a-z]+)", "abdcxyz");

        // В третьем случае первой группе будет соответствовать вся строка, а для второй
        // не остается ни одного символа, так как вторая группа использует слабое совпадение.
        myMatches("([a-z]+)([a-z]*)", "abdcxyz");

        // В четвертом случае строка не соответствует регулярному выражению,
        // т. к. для двух групп выбирается наименьшее количество символов.
        myMatches("([a-z]?)([a-z]?)", "abdcxyz");
    }

    public static void myMatches(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("First group: " + matcher.group(1));
            System.out.println("Second group: " + matcher.group(2));
        } else {
            System.out.println("Nothing");
        }
        System.out.println();
    }
}