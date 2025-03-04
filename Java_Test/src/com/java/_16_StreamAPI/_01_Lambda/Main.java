package com.java._16_StreamAPI._01_Lambda;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

/*
Лямбда представляет набор инструкций, которые можно выделить в отдельную
переменную и затем многократно вызвать в различных местах программы
Основу лямбда выражения составляет лямбда оператор, который представляет
стрелку ->. Синтаксис лямбда выражения имеет вид:

параметры -> тело функции

Типы параметров можно опускать

Основные преимущества
• лаконичный и выразительный код

Дополнительные преимущества
• Функциональный подход: многие классы задач решаются проще, код
становится легким для чтения, что упрощает его дальнейшее
сопровождение
• Поддержка потоков: потоки являются обертками источников данных
(массивы коллекции), которые используют лямбда выражения
Лямбда выражение не выполняется само по себе, а образует реализацию метода,
определенного в функциональном интерфейсе или SAM интерфейсом(Single Abstract Method)
При этом важно, что функциональный интерфейс должен содержать только один
единственный метод без реализации

Выведение типов
• В списке аргументов можно пренебречь
указанием типов
• Общий вид λ выражения
(тип 1 var 1, тип 2 var 2) -> { тело метода }

• λ выражение с выведением типов
(var 1 var 2) -> { тело метода }

Скобки
• Если метод зависит от одного аргумента, скобки можно опустить
• В таком случае тип аргумента не указывается

varName -> someResult()

• Лямбда выражения используют статические области действия переменных

Выводы
•Ключевое слово this ссылается на внешний класс, а не на анонимный (в который преобразуется лямбда выражение)
•Нет переменной OuterClass.this До тех пор, пока лямбда внутри вложенного класса
•Лямбда не может создавать новые переменные с такими же именами, как у метода, вызвавшего лямбда
•Лямбда может ссылаться (но не изменять) локальные переменные из окружающего кода
•Лямбда может обращаться (и изменять) переменные экземпляра окружающего класса
 */
public class Main {
    static int st = 20;
    int inst = 30;
    @Test
    public void TestLambda1() {
        int i = 30;// Не может изменяться внутри анонимного класса или лямбда выражения
        IElectricityConsumer user1 = new IElectricityConsumer() {
            @Override
            public void electricityOn(Object sender) {
                //i = 20;//Error Variable used in lambda expression should be final or effectively final
                st = 20;
                inst = 21;
                System.out.println(sender);
                System.out.println(i);
            }
        };

        IElectricityConsumer user2 = (j) -> {
            //i = 20;//Variable used in lambda expression should be final or effectively final
            st = 30;
        };
        user2.electricityOn(89);

//        IUser user2 = (i) -> {
//            {
//                //int i = 30;
//                System.out.println(i);
//            }
//        };
    }

    @Test
    public void TestLambda2Metrics() {
        long l1 = System.nanoTime();
        IElectricityConsumer user10 = new IElectricityConsumer() {
            @Override
            public void electricityOn(Object sender) {
                System.out.println("Hello");
            }
        };
        long l2 = System.nanoTime();

        long l3 = System.nanoTime();
        IElectricityConsumer user20 = (x) -> System.out.println("Hello");
        long l4 = System.nanoTime();

        System.out.println(l2 - l1);
        System.out.println(l4 - l3);

        System.out.println(user10);
        System.out.println(user20);
    }

    @Test
    public void TestLambda4(){
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

        /* Лямбда выражение
            1) Если у нас 1 параметр, то мы можем не указывать тип параметра
            2) Круглые скобки можно опустить
        */
        switcher.addElectricityListener(sender -> System.out.println(message));

        switcher.addElectricityListener((Object sender) -> System.out.println("Пожар 2"));

        switcher.addElectricityListener(sender -> {
            System.out.print("Пожар 3");
            System.out.println("!!!");
        });

        switcher.addElectricityListener(s -> TestStaticMethodClass.fire(s));

        // :: - в данном случае указывает на то, что используем именно метод fire
        // сокращение с "::" возможно тогда, когда в методе кол-во параметров совпадает с лямбда-выражением
        switcher.addElectricityListener(TestStaticMethodClass::fire);
        switcher.addElectricityListener(new TestStaticMethodClass()::fireInst);

        switcher.switchOn();
        /*
        Выключатель ключен
        Лампа зажглась
        Radio plays
        Пожар
        Пожар 2
        Пожар 3!!!
        Fire!!!
        Fire!!!
        Fire Inst!!!
         */
    }
}

