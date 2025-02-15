package com.java._16_StreamAPI._01_Lambda.withoutLambdaExpression;

import org.junit.Test;

public class Main {

    @Test
    public void TestLambda1(){
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        // Подписка на событие(Подписываемся 1 раз и не зависимо сколько раз
        // вызовется включение лампы, столько раз будет вызыватся метод лампы)
        switcher.addElectricityListener(lamp);
        switcher.addElectricityListener(radio);

        // Захват переменных, можем передать в анонимный класс/лямбда выражение
        String message = "Пожар";
        // Если изменяем значение переменной - ошибка компиляции
        // message = "Fire";


        // Громоздкая запись для 1 метода
        class Fire implements IElectricityConsumer {
            public void electricityOn(Object sender){
                System.out.println("Пожар 2");
            }
        }
        switcher.addElectricityListener(new Fire());
        // Анонимный класс
        switcher.addElectricityListener(
                new IElectricityConsumer() {
                    public void electricityOn(Object sender) {
                        System.out.println(message);
                    }
                }
        );

        switcher.switchOn();

        /*
        Выключатель включен
        Лампа зажглась
        Radio plays
        Пожар 2
        Пожар
         */
    }
}
