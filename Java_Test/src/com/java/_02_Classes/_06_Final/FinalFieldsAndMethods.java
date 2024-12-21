package com.java._02_Classes._06_Final;

public class FinalFieldsAndMethods {

	//Модификатор static – определяет поле или метод, который принадлежит непосредственно КЛАССУ.
	//Для вызова статического поля или метода не требуется создавать экземпляр класса.
	// объявление константы
	public static final int a = 3;
    public static final int d;
    public final int b;
    public final int e;

    static {
        //a = 5;// константу менять НЕЛЬЗЯ!
		d = 5;
    }

    {
        e = 7;
		//d = 3; // константу менять НЕЛЬЗЯ!
    }

    public FinalFieldsAndMethods() {
		//d = 5;
		b = 6;
		//e = 7;
    }

    public FinalFieldsAndMethods( int c ) {
        //d= 5;
        b = c;
		//e = 7;
    }

    public static void doSmth() {
        System.out.println("Hello !");
    }
}
