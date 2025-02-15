package com.java._09_DateTime;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.DayOfWeek;

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
}