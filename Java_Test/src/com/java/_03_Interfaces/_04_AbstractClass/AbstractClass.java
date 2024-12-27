package com.java._03_Interfaces._04_AbstractClass;

import com.java._03_Interfaces._01_Base.SomeInterface;

public abstract class AbstractClass implements SomeInterface {
    // Реализация абстрактного метода из интерфейса, в абстрактном классе не обязательна.
//    public void method() {
//        System.out.println("AbstractClass.method");
//    }

    //  Перезапись абстрактного метода из интерфейса, в абстрактном классе не обязательна.
    public abstract void method();
}

