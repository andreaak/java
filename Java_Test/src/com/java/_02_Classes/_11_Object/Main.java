package com.java._02_Classes._11_Object;

import org.junit.Test;

/*
Object – это базовый класс для всех остальных объектов в Java.
Каждый класс наследуется от Object. Соответственно все классы
наследуют методы класса Object.

public final native Class getClass() – возвращает объект класса Class, который описывает класс (имя,
методы, поля), от которого был порожден этот объект.

public native int hashCode() – возвращает значение int. Цель хэш-кода – представить любой объект
целым числом. Необходимо, чтобы объекты, равные по значению, возвращали одинаковые хэш-коды.

public boolean equals(Object obj) – служит для сравнения объектов по значению, а не по ссылке.
Сравнивается состояние объекта, у которого вызывается этот метод, с передаваемым аргументом.

public String toString() – позволяет получить текстовое описание любого объекта. Создавая новый
класс, данный метод можно переопределить и возвращать более подробное описание. Для класса
Object и его наследников, не переопределивших toString(), метод возвращает следующее выражение:
getClass().getName()+"@"+hashCode()

protected native Object clone() throws CloneNotSupportedException – при выполнении метода clone() сначала
проверяется, можно ли клонировать исходный объект. Если разработчик хочет сделать объекты своего
класса доступными для клонирования через Object.clone(), то он должен реализовать в своем классе
интерфейс Cloneable. В этом интерфейсе нет ни одного элемента, он служит лишь признаком для
виртуальной машины, что объекты могут быть клонированы. В ином случае, метод порождает ошибку
CloneNotSupportedException.
Если интерфейс Cloneable реализован, то порождается новый объект от того же класса, от которого был
создан исходный объект. При этом копирование выполняется на уровне виртуальной машины, никакие
конструкторы не вызываются. Затем значения всех полей, объявленных, унаследованных либо объявленных
в родительских классах, копируются. Полученный объект возвращается в качестве клона.
Примитивные поля копируются и далее существуют независимо в исходном и клонированном объектах.
Изменение одного не сказывается на другом.
Ссылочные поля копируются по ссылке, оба объекта ссылаются на одну и ту же область памяти (исходный
объект). Поэтому изменения, происходящие с исходным объектом, сказываются на клонированном.

public final native void notify() – возобновляет выполнение потока, который ожидает вызывающего объекта.

public final native void notifyAll() – возобновляет выполнение всех потоков, которые ожидают вызывающего
объекта.

public final void wait() throws InterruptedException – переводит выполнение потока в режим ожидания пока
не будет вызван метод notify() или notifyAll().

public final native void wait(long timeout) throws InterruptedException – перегруженный метод. переводит
выполнение потока в режим ожидания пока не будет вызван метод notify() или notifyAll() или пока не
истечет timeout, заданный в миллисекундах.

public final void wait(long timeout, int nanos) throws InterruptedException – перегруженный метод.
переводит выполнение потока в режим ожидания пока не будет вызван метод notify() или пока не истечет
период времени timeout+nanos, заданный в миллисекундах и наносекундах соответственно.

protected void finalize() throws Throwable – данный метод вызывается при уничтожении
объекта автоматическим сборщиком мусора (garbage collector). В классе Object он ничего не
делает, однако в классе-наследнике позволяет описать все действия, необходимые для
корректного удаления объекта, такие как закрытие соединений с БД, сетевых соединений,
снятие блокировок на файлы и т.д. В обычном режиме напрямую этот метод вызывать не
нужно, он отработает автоматически. Если необходимо, можно обратиться к нему явным
образом.
В методе finalize() нужно описывать только дополнительные действия, связанные с логикой
работы программы. Все необходимое для удаления объекта JVM сделает сама.
*/

public class Main {

    @Test
    public void Test1toString() {
        Car car = new Car(160, "blue");

        // возвращает класс объекта
        System.out.println(car.getClass());

        // благодаря перезаписаному методу toString выведет информацию в нужном нам виде
        System.out.println(car);

        CarOverridden car2 = new CarOverridden(160, "blue");
        System.out.println(car2.getClass());
        System.out.println(car2);

        /*
        class com.java._02_Classes._11_Object.Car
        com.java._02_Classes._11_Object.Car@1b0375b3
        class com.java._02_Classes._11_Object.CarOverridden
        Speed is: 160 and Color is: blue
         */
    }

    @Test
    public void Test2DefaultEquals() {
        Car car1 = new Car(1, "blue");
        Car car2 = new Car(2, "blue");
        Car car3 = car1;
        // сравниваем по ссылкам (разные объекты)
        System.out.println(car1.equals(car2));
        // ссылаемся на один и тот же объект
        System.out.println(car1.equals(car3));
        System.out.println(car1 == car2);
        System.out.println(car1 == car3);

        /*
        false
        true
        false
        true
         */
    }

    @Test
    public void Test3OverriddenEquals() {
        CarOverridden car1 = new CarOverridden(1, "blue");
        CarOverridden car2 = new CarOverridden(2, "blue");
        CarOverridden car3 = car2;
        CarOverridden car4 = new CarOverridden(2, "blue");

        System.out.println(car1.equals(car2));
        System.out.println(car1.equals(car3));
        System.out.println(car2.equals(car3));
        System.out.println(car2.equals(car4));
        System.out.println(car1.equals(car4));

        /*
        false
        false
        true
        true
        false
        */
    }

    @Test
    public void Test4DefaultHashcode() {
        Car car1 = new Car(1, "blue");
        Car car2 = new Car(2, "blue");
        Car car3 = new Car(2, "blue");

        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        /*
        453211571
        796684896
        757108857
        */
    }

    @Test
    public void Test4OverriddenHashcode() {
        CarOverridden car1 = new CarOverridden(1, "blue");
        CarOverridden car2 = new CarOverridden(2, "blue");
        CarOverridden car3 = new CarOverridden(2, "blue");

        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        /*
        -1758777999
        806948410
        806948410
        */
    }

    @Test
    public void Test5Finalize() {
        Car car = new Car(1, "blue");
        car = null;
        System.gc();

        /*
        Finalize
        */
    }
}


