package com.java._21_DateTime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.DayOfWeek;

/*
Класс Date – предназначен для работы с текущими датой и временем и позволяет отталкиваться от них для решения своих задач.
Клас Date зберігає дату в мілісекундах , що пройшли з 1 січня 1970 року. 01.01.1970 Unix-час.

Класс GregorianCalendar является подклассом Calendar, который представляет обычный Григорианский календарь.
Метод getInstance() класса Calendar обычно возвращает объект класса GregorianCalendar,
инициированный текущей датой и временем согласно региональным настройкам.
У класса есть два поля AD и BC до нашей эры и наша эра

1. Клас LocalDateTime є потужним інструментом для роботи з локальними датами та часом в
Java . Він дозволяє зручно виконувати операції з датою та часом, порівнювати та сортувати
об'єкти LocalDateTime .
2. LocalDateTime зберігає різні компоненти дати та часу рік, місяць, день, години, хвилини та
секунди.
3. LocalDateTime не містить інформацію про часовий пояс. Він просто представляє локальну
дату та час відносно системи, на якій виконується програма.
4. LocalDateTime є незмінним класом, тобто після створення об'єкта LocalDateTime його
значення не може бути змінено. Замість цього для виконання операцій з датою та часом
повертаються нові об'єкти LocalDateTime з внесеними змінами.
5. LocalDateTime реалізує інтерфейси Comparable та Comparator , що дозволяє порівнювати
та сортувати об'єкти LocalDateTime

1. Joda Time надає більше можливостей та функцій порівняно з LocalDateTime . Він має
додаткові класи для представлення часових зон ( DateTimeZone ), періодів Period ),
інтервалів ( Interval ), дати з часовим поясом DateTime ) та
2. Joda Time має більш розширену підтримку часових поясів. Він надає клас DateTimeZone ,
що дозволяє працювати з різними часовими поясами та виконувати конвертацію між ними.
У LocalDateTime в java.time API підтримка часових поясів обмежена.
3. Joda Time має багато методів для роботи з датою та часом, що дозволяє виконувати
складні операції та маніпулювати даними. Наприклад, в Joda Time є методи для
визначення першого/останнього дня місяця, перевірки на належність до вихідних днів
тижня, обчислення кількості робочих годин між двома датами тощо.
*/

public class Main {

    @Test
    public void TestDate1() {
        Date date = new Date();
        long millis = date.getTime();
        System.out.println(millis);
    }

    @Test
    public void TestDate2GregorianCalendar() {

        GregorianCalendar d = new GregorianCalendar();
        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        d.set(Calendar.DAY_OF_MONTH, 1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);
        System.out.println(" Sun   Mon   Tue   Wed   Thu   Fri   Sat");

        for (int i = Calendar.SUNDAY; i < weekday; i++) {
            System.out.print("      ");
        }

        do {
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%4d", day);
            if (day == today) {
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }
            if (weekday == Calendar.SATURDAY) {
                System.out.println();
            }
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (d.get(Calendar.MONTH) == month);
    }

    @Test
    public void TestDate3GregorianCalendar() {
        GregorianCalendar gc = new GregorianCalendar();
        System.out.println(gc.get(Calendar.DAY_OF_MONTH));
        // Месяц на 1 меньше
        System.out.println(gc.get(Calendar.MONTH));
        System.out.println(gc.get(Calendar.DAY_OF_YEAR));
        System.out.println(gc.get(Calendar.DAY_OF_WEEK));

        System.out.println((char) 27 + "[31m" + "===========================");
        gc.set(Calendar.MONTH, Calendar.JANUARY);
        // День на 1 больше( 7 = 1 )
        gc.set(Calendar.DAY_OF_MONTH, 12);
        System.out.println(gc.get(Calendar.DAY_OF_WEEK));

        System.out.println((char) 27 + "[32m" + "===========================");
        GregorianCalendar gc1 = new GregorianCalendar(2018, Calendar.JANUARY, 12);
        System.out.println(gc1.get(Calendar.DAY_OF_WEEK));

        System.out.println((char) 27 + "[33m" + "===========================");

        GregorianCalendar gc2 = new GregorianCalendar(2018, Calendar.DECEMBER, 28);
        gc2.add(Calendar.DAY_OF_MONTH, 5);
        System.out.println(gc2.get(Calendar.DAY_OF_MONTH));
        System.out.println(gc2.get(Calendar.MONTH));
        System.out.println(gc2.get(Calendar.YEAR));

        System.out.println((char) 27 + "[34m" + "===========================");
        // Преобразуем GregorianCalendar в Date
        Date d1 = gc2.getTime();
        System.out.println(d1);

        // Преобразуем Date в GregorianCalendar
        gc.setTime(d1);
        System.out.println(gc.get(Calendar.DAY_OF_MONTH));
        System.out.println(gc.get(Calendar.MONTH));
        System.out.println(gc.get(Calendar.YEAR));
    }

    @Test
    public void TestDate4LocalTime() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localTime);
        System.out.println(localDate);
        System.out.println(localDateTime);

        System.out.println("=============");

        // Слияние 2-х объектов
        LocalDateTime fromLocalTime = localTime.atDate(localDate);
        LocalDateTime fromDateTime = localDate.atTime(localTime);

        System.out.println(fromLocalTime);
        System.out.println(fromDateTime);

        System.out.println("=============");

        fromDateTime = localDate.atTime(12,00,57,01);
        System.out.println(fromDateTime);

        System.out.println("=============");
        localDate = localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(localDate);
    }

    @Test
    public void TestDate5LocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Current date: " + localDateTime);

        LocalDateTime customDate = LocalDateTime.of(2024, 2, 25, 13, 18, 35);
        System.out.println("Custom date: " + customDate);

        System.out.println("Custom date is before current date: " + customDate.isBefore(localDateTime));
        System.out.println("Custom date is after current date: " + customDate.isAfter(localDateTime));

        System.out.println("Year: " + localDateTime.getYear());
        System.out.println("Month: " + localDateTime.getMonthValue());
        System.out.println("Day of month: " + localDateTime.getDayOfMonth());
        System.out.println("Day of year: " + localDateTime.getDayOfYear());
        System.out.println("Day of week: " + localDateTime.getDayOfWeek().getValue());

        System.out.println("Plus 3 days: " + localDateTime.plusDays(3));
        System.out.println("Plus 2 weeks: " + localDateTime.plusWeeks(2));
        System.out.println("Plus 1 month: " + localDateTime.plusMonths(1));
        System.out.println("Plus 5 years: " + localDateTime.plusYears(5));

        System.out.println("Minus 3 days: " + localDateTime.minusDays(3));
        System.out.println("Minus 2 weeks: " + localDateTime.minusWeeks(2));
        System.out.println("Minus 1 month: " + localDateTime.minusMonths(1));
        System.out.println("Minus 5 years: " + localDateTime.minusYears(5));
    }

    @Test
    public void TestDate6JodaTime() {
        DateTime currentDate = new DateTime(DateTimeZone.UTC);
        System.out.println(currentDate);

        DateTime customDate = new DateTime("2024-02-20T11:55:48");
        System.out.println("Custom date: " + customDate);

        // Formatter
        DateTimeFormatter dtf = DateTimeFormat.forPattern("d MMMM, yyyy");
        System.out.println(currentDate.toString(dtf));

        // duartion
        Duration duration = new Duration(customDate, currentDate);
        int days = duration.toStandardDays().getDays();
        System.out.println("Days between current date and custom date: " + days);

        // first and last day of month
        int year = 2024;
        int month = 2;

        DateTime firstDate = new DateTime(year, month, 1, 0, 0, 0).dayOfMonth().withMinimumValue();
        System.out.println("First day of month: " + firstDate);

        DateTime lastDate = new DateTime(year, month, 1, 0, 0, 0).dayOfMonth().withMaximumValue();
        System.out.println("Last day of month: " + lastDate);

        // is weekend
        DateTime weekend = new DateTime(2024, 2, 26, 0,0,0);
        System.out.println("Today is weekend: " + isWeekend(weekend));

        // calculate working hours between 2024-01-01 09:00:00 and 2024-01-03 15:30:00
        DateTime startDate = new DateTime("2024-01-01T09:00:00");
        DateTime endDate = new DateTime("2024-01-03T15:30:00");

        System.out.println("Working hours: " + calculateWorkingHours(startDate, endDate));
    }

    private static boolean isWeekend(DateTime dateTime) {
        int dayOfWeek = dateTime.getDayOfWeek();
        return dayOfWeek == DateTimeConstants.SATURDAY || dayOfWeek == DateTimeConstants.SUNDAY;
    }

    private static int calculateWorkingHours(DateTime startDate, DateTime endDate) {
        int totalHours = 0;

        DateTime tempDate = startDate;
        while (tempDate.isBefore(endDate) || tempDate.isEqual(endDate)) {
            // Початок робочого дня о 9:00
            DateTime startOfDay = tempDate.withTime(9, 0, 0, 0);
            // Кінець робочого дня о 17:30
            DateTime endOfDay = tempDate.withTime(17, 30, 0, 0);

            DateTime actualStartDateTime = (startDate.isAfter(startOfDay)) ? startDate : startOfDay;
            DateTime actualEndDateTime = (endDate.isBefore(endOfDay)) ? endDate : endOfDay;

            if (actualStartDateTime.isBefore(actualEndDateTime)) {
                Duration duration = new Duration(actualStartDateTime, actualEndDateTime);
                int workingHours = duration.toStandardHours().getHours();
                totalHours += workingHours;
            }

            tempDate = tempDate.plusDays(1);
        }

        return totalHours;
    }


}