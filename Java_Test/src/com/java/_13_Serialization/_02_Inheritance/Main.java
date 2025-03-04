package com.java._13_Serialization._02_Inheritance;

import com.java._13_Serialization._00_Models.Clutch;
import com.java._13_Serialization._00_Models.Engine;
import org.junit.Test;

import java.io.*;

/*
Cериализация предполагает, что все поля объекты, подлежащие
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

        Bmw c = new Bmw(1000, 5000, "x6", new Engine(1500, "BMW"), new Clutch(100, "ZF"));
        System.out.println(c);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            // Сериализуем объект Bmw в байт-код
            oos.writeObject(c);

            // Десериализуем объект Bmw с байт-кода
            // При десериализации вызывается конструктор суперкласса
            Bmw newBmw = (Bmw) ois.readObject();
            System.out.println(newBmw);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*
        Engine Constructor
        Clutch Constructor
        Car Constructor
        Bmw Constructor
        Bmw{price=5000, model='x6', engine=Engine{power=1500, producer='BMW'}, clutch=Clutch{power=100, producer='ZF'}, weight=1000}

        Car default Constructor
        Bmw{price=5000, model='x6', engine=null, clutch=Clutch{power=100, producer='ZF'}, weight=10000}
         */
    }
}