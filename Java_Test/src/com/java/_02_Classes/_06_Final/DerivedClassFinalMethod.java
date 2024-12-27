package com.java._02_Classes._06_Final;

class FinalMethod {
    public final void show(){
        System.out.println("FinalClassMethod.show");
    }
}

//Модификатор final можно использовать и с методами. Это позволяет
//запретить переопределять методы в производных классах.
public class DerivedClassFinalMethod extends FinalMethod {

    public DerivedClassFinalMethod() {
        super.show();
    }

// Попытка переопределить show приводит к ошибке компилятора.
//    @Override
//    public void show(){
//
//    }

//    public int show(){
//
//    }

    public void show(int a){

    }
}



