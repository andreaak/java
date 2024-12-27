package com.java._02_Classes._07_Static;

public class StaticFieldsAndMethods {

	// объявление константы
	public static final int a = 3;
    public static final int b;
    public static int c;

    /*
    статические конструкторы
     */
    static {
        //a = 5;// константу менять НЕЛЬЗЯ!
		b = 4;
        c = 5;
    }

    static {
        //a = 5;// константу менять НЕЛЬЗЯ!
        //b = 4;
        c = 5;
    }

    public StaticFieldsAndMethods() {
		//b = 4;
        c = 5;
    }

    public StaticFieldsAndMethods(int c ) {
        //b= 4;
        this.c = c;
    }

    public static void doSmth() {

        System.out.println("StaticFieldsAndMethods Static method");
    }
}

class DerivedStaticFieldsAndMethods extends StaticFieldsAndMethods {

    //@Override
    public static void doSmth() {

        System.out.println("DerivedStaticFieldsAndMethods Static method");
    }
}

