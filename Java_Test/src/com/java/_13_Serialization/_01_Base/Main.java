package com.java._13_Serialization._01_Base;

import com.java._13_Serialization._00_Models.Clutch;
import com.java._13_Serialization._00_Models.Engine;
import org.junit.Test;

import java.io.*;

/*
Сериализация представляет собой процесс передачи состояния объекта в поток
байтов с целью сохранения его в памяти, в базе данных или в файле
Основное назначение сериализации сохранить состояние объекта для того,
чтобы иметь возможность восстановить его в случае необходимости
Процесс обратный сериализации называется десериализацией
Межпроцессная междоменная и межуровневая сериализация-десериализация
называется маршалингом-демаршалингом

Класс сериализуемого объекта должен реализовать интерфейс java io Serializable
Интерфейс Serializable это интерфейс маркер, в нём не задекларировано ни одного
метода. Он говорит сериализующему механизму, что класс может быть сериализован
По умолчанию процесс сериализации заключается в сериализации каждого поля
объекта, которое не обозначено как transient или static
Также, данный процесс предполагает, что все поля объекты, подлежащие
сериализации, должны указывать на типы, в свою очередь поддерживающие
возможность сериализации
Кроме того, требуется, чтобы класс базовый по отношению к рассматриваемому,
либо обладал конструктором без параметров дабы таковой мог быть вызван в
процессе десериализации,
Либо сам в свою очередь обеспечивал реализацию интерфейса Serializable (в таком
случае реализация того же интерфейса в производном классе будет избыточным
решением)
*/

public class Main {
    @Test
    public void TestSerialization1() {
        // Создаем объект класса файл и указываем файл
        File f = new File("files\\file1.txt");
        // значение на 1000 не меняет, необходимо изменить Car implements Serializable
        Bmw c = new Bmw(5000, "x6", new Engine(1500, "BMW"), new Clutch(100, "ZF"));
        System.out.println(c);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            // Сериализуем объект Bmw в байт-код
            oos.writeObject(c);

            c.testStatic = 50;

            // Десериализуем объект Bmw с байт-кода
            Bmw newBmw = (Bmw) ois.readObject();
            System.out.println(newBmw);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*
        Engine Constructor
        Clutch Constructor
        Bmw Constructor
        Bmw{price=5000, model='x6', engine=Engine{power=1500, producer='BMW'}, clutch=Clutch{power=100, producer='ZF'}, testStatic=45}

        Bmw{price=5000, model='x6', engine=null, clutch=Clutch{power=100, producer='ZF'}, testStatic=50}
        */
    }
}