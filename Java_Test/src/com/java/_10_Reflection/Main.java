package com.java._10_Reflection;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Map;
/*
• public boolean islnterface возвращает true, если объект Class представляет
интерфейс
• public boolean isArray возвращает true, если объект Class представляет
массив
• public boolean isPrimitive возвращает true, если объект Class представляет
один из простых типов или служебное слово void
• public Class getlnterfaces возвращает массив объектов Class элементы
которого соответствуют интерфейсам, реализуемым текущим типом
Если интерфейсов, базовых по отношению к типу, не существует из за
того, например, что тип не реализует интерфейсы непосредственно или
является простым, возвращается массив нулевой длины
• public Class getSuperclass возвращает объект Class который соответствует
классу, базовому по отношению к текущему типу
Метод возвращает null если текущий объект Class представляет класс
Object интерфейс простой тип или служебное слово void (все они не
обладают базовыми классами)
• public int getModifiers возвращает модификаторы, используемые в
объявлении типа, в виде кодированного целочисленного значения Значение
должно декодироваться с помощью констант и методов класса Modifier
• public Class getComponentType возвращает объект класса Class который
представляет компонентный тип массива, описываемого текущим объектом Class
Если текущий объект Class не соответствует массиву, возвращается null
Пусть например, задан массив значений int Тогда
метод getClass возвратит объект Class для которого метод запрос
isArray вернет значение true а метод getComponentType объект int class

public static Class forName( String name, boolean initialize, ClassLoader loader)
throws ClassNotFoundException возвращает объект Class соответствующий
названному по имени классу или интерфейсу, с помощью заданного загрузчика
классов
Используя полное имя класса или интерфейса, переданное в качестве
параметра name метод предпринимает попытку обнаружить и загрузить класс
или интерфейс
Для загрузки класса или интерфейса применяется заданный загрузчик классов
Если значение параметра loader равно null используется системный загрузчик
классов
Класс инициализируется только при условии, что значение параметра initialize
равно true и ранее инициализация класса не выполнялась
Если класс с заданным именем не может быть найден, выбрасывается
объявляемое исключение типа ClassNotFoundException

 */

public class Main {
    @Test
    public void TestReflection1Class() {
        // 1. getClass()
        Main simpleReflection = new Main();
        Class<?> cl = simpleReflection.getClass();

        int[] arr = new int[10];
        Class<?> cl2 = arr.getClass();
        Class<?> cl3 = "world".getClass();
        Class<?> cl4 = Integer.valueOf(5).getClass();
        System.out.println(cl);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println(cl4);

        //2. String.class
        Class<?> cl5 = Main.class;
        Class<?> cl6 = int[].class;

        //3. Class.forName()
        try {
            Class<?> cl7 = Class.forName("java.lang.String");
            System.out.println(cl);

            Class<?> cl8 = Class.forName("[I");//Integer array
            Class<?> cl9 = Class.forName("[D");//Double array
            System.out.println(cl9);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //4.
        Class<?> cl10 = Integer.class.getSuperclass();
        System.out.println(cl10);

        Class<?> cl11 = Map.Entry.class.getEnclosingClass();
        System.out.println(cl11);
        /*
        class com.java._10_Reflection.Main
        class [I
        class java.lang.String
        class java.lang.Integer
        class com.java._10_Reflection.Main
        class [D
        class java.lang.Number
        interface java.util.Map
         */
    }

    @Test
    public void TestReflection2Fields() {
        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";
        // Получаем класс который описывает класс CatMethods
        Class<?> cl = Cat.class;
        System.out.println(s + "Public Reflection fields:");
        // Метод getFields(), возвращает только поля с модификатором public
        Field[] fields = cl.getFields();
        // Пробегаемся по классу Field и выводим все public поля
        for (Field field : fields) {
            Class<?> fieldType = field.getType();
            System.out.println(s2 + "\tName: " + s1 + field.getName());
            System.out.println(s2 + "\tType: " + s1 + fieldType.getName());
        }

        System.out.println(s + "All Modifiers Reflection fields:");
        fields = cl.getDeclaredFields();
        for (Field field : fields) {
            Class<?> fieldType = field.getType();
            System.out.println(s2 + "\tName: " + s1 + field.getName());
            System.out.println(s2 + "\tType: " + s1 + fieldType.getName());
        }
        /*
        Public Reflection fields:
            Name: name
            Type: java.lang.String
        All Modifiers Reflection fields:
            Name: name
            Type: java.lang.String
            Name: age
            Type: int
            Name: ears
            Type: short
            Name: tail
            Type: long
         */
    }

    @Test
    public void TestReflection3Constructors() {
        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";
        // Получаем класс который описывает класс CatMethods
        Class<?> cl = Cat.class;

        System.out.println(s + "Constructors:" + s1);
        // Получаем массив конструкторов
        Constructor<?>[] constructors = cl.getConstructors();
        int i = 0;
        for (Constructor<?> ctr : constructors) {
            // Выводим типы параметров каждого конструктора
            System.out.print(s + "\tConstructor "  + (++i) + ": ");
            Class<?>[] paramTypes = ctr.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                System.out.print(s1 + paramType.getName() + " ");
            }
            System.out.println();
        }
        try {
            // Создаем массив и получаем ссылку на класс с определенным типом параметров
            Class<?>[] paramTypes = new Class<?>[]{
                    int.class
            };
            // Получаем ссылку на конструктор с определенным параметром
            Constructor<?> ctr = cl.getConstructor(paramTypes);
            // newInstance  = new, передаем объект
            Cat cm = (Cat) ctr.newInstance(Integer.valueOf(1));
            System.out.println(s + "Fields: " + s1 + " Age - " + cm.getAge() + ", Name - " + cm.getName() + ", Ears - " + cm.getEars() + ", Tail - " + cm.getTail());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /*
        Constructors:
            Constructor 1:
            Constructor 2: int
            Constructor 3: java.lang.String int short long
        Fields:  Age - 1, Name - Marsel, Ears - 5, Tail - 30
         */

    }

    @Test
    public void TestReflection4Methods() {
        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";
        // Получаем класс который описывает класс CatMethods
        Class<?> cl = Cat.class;

        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            System.out.println(s + "Name: " + s2 + method.getName());
            System.out.println(s + "\tReturn type: " + s1 + method.getReturnType().getName());
            Class<?>[] paramTypes = method.getParameterTypes();
            System.out.print(s + "\tParam types:" + s1);
            for (Class<?> paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println();
        }

        try {
            Cat cm = new Cat();
            Class<?>[] paramTypes = new Class<?>[]{int.class};
            // Получаем ссылку на метод с именем setAge и параметром int
            Method method = cl.getMethod("setAge", paramTypes);
            Object[] objArguments = new Object[]{Integer.valueOf(8)};
            // Метод invoke принимает два параметра:
            // первый - это объект, класс которого объявляет или наследует данный метод,
            // второй - массив значений параметров, которые передаются вызываемому методу
            method.invoke(cm, objArguments);
            System.out.println(s + "Age: " + s1 + cm.getAge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Cat obj = new Cat();
            Class<?>[] paramTypes = new Class<?>[]{String.class};
            // Пытаемся вызвать не существующий метод
            Method method = cl.getMethod("justMethod", paramTypes);
            Object[] arguments = new Object[]{Integer.valueOf("Hello")};
            method.invoke(obj, arguments);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Test
    public void TestReflection5Modifiers() {
        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";
        // Получаем класс который описывает класс CatModifier
        Class cl = Cat.class;
        // Узнаем имя класса
        System.out.println(s + "Class name: " + s1 + cl.getName());
        System.out.print(s + "Modifiers of class: " + s1);
        // getModifiers(), возвращает целочисленное значение
        int mods = cl.getModifiers();
        if (Modifier.isPrivate(mods)) {
            System.out.print("private ");
        }
        if (Modifier.isAbstract(mods)) {
            System.out.print("abstract ");
        }
        if (Modifier.isStatic(mods)) {
            System.out.print("static ");
        }
        if (Modifier.isFinal(mods)) {
            System.out.print("final ");
        }
    }

    @Test
    public void TestReflection6Access() {
        try {
            Class<Cat> cl = Cat.class;

            Cat dog = new Cat();
            // По имени name получаем класс Field
            Field field = cl.getDeclaredField("age");
            // true - снимаем модификатор до public, false - запрещаем
            field.setAccessible(true);
            // У класса Field, есть различные методы get
            System.out.println("Private field value: " + field.getInt(dog));
            field.setInt(dog, 10);
            System.out.println("New private field value: " + field.getInt(dog));

            /*
            Private field value: 7
            New private field value: 10
             */
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void TestReflection7Members() {
        try {
            // Получаем объект типа класс
            Class<?> c = Class.forName("com.java._10_Reflection.Cat");
            System.out.println(c);
            // Вызываем все поля класса
            printMembers(c.getFields());
            // Вызываем все конструкторы класса
            printMembers(c.getConstructors());
            // Вызываем все методы класса
            printMembers(c.getMethods());
            /*
            class com.java._10_Reflection.Cat
            public java.lang.String com.java._10_Reflection.Cat.name
            public com.java._10_Reflection.Cat(int)
            public com.java._10_Reflection.Cat()
            public com.java._10_Reflection.Cat(java.lang.String,int,short,long)
            public void com.java._10_Reflection.Cat.setAge(int)
            public int com.java._10_Reflection.Cat.getAge()
            public short com.java._10_Reflection.Cat.getEars()
            public long com.java._10_Reflection.Cat.getTail()
            public void com.java._10_Reflection.Cat.setEars(short)
            public void com.java._10_Reflection.Cat.setTail(long)
            public java.lang.String com.java._10_Reflection.Cat.getName()
            public void com.java._10_Reflection.Cat.setName(java.lang.String)
             */
        } catch (ClassNotFoundException e) {
            System.out.println("Неизвестный класс:" + "Cat");
        }
    }

    private static void printMembers( Member[] mems) {
        // Пробегаемся по всей длине интерфейса Member
        for (int i = 0; i < mems.length; i++) {
            if (mems[i].getDeclaringClass() == Object.class) {
                continue;
            }
            String decl = mems[i].toString();
            System.out.print("   ");
            System.out.println(decl);
        }
    }
}