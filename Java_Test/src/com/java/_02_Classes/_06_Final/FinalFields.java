package com.java._02_Classes._06_Final;

public class FinalFields {

	//Модификатор static – определяет поле или метод, который принадлежит непосредственно КЛАССУ.
	//Для вызова статического поля или метода не требуется создавать экземпляр класса.
	// объявление константы
	public static final int a = 3;
    public static final int b;
    public final int c;
    public final int e;

    static {
        //a = 3;// константу менять НЕЛЬЗЯ!
		b = 4;
    }

    {
        e = 6;
		//b = 4; // константу менять НЕЛЬЗЯ!
    }

    public FinalFields() {
		//b = 4;
		c = 5;
		//e = 6;
    }

    public FinalFields(int c ) {
        //b= 4;
        this.c = c;
		//e = 6;
    }
}
