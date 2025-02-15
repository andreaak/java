package com.java._06_Generics._04_Wildcards;

import com.java._06_Generics._01_Base.GenericClass;
import com.java._06_Generics._01_Base.GenericMultyArgumentClass;
import com.java._06_Generics._02_Method.GenericMethod;
import org.junit.Test;

public class Main {

    @Test
    public void Test1Wildcards() {
        NumericFns<Integer> iOb = new NumericFns<Integer>(6);
        NumericFns<Double> dOb = new NumericFns<Double>(-6.0);
        NumericFns<Long> lOb = new NumericFns<Long>(5L);

        System.out.println("Сравнение iOb и dOb.");
        if (iOb.absEqual(dOb))
            System.out.println("Абсолютные значения одинаковы .");
        else
            System.out.println("Абсолютные значения отличаются.");

        System.out.println("Сравнение iOb и lOb.");
        if (iOb.absEqual(lOb))
            System.out.println("Абсолютные значения одинаковы .");
        else
            System.out.println("Абсолютные значения отличаются.");
    }

    @Test
    public void Test2BoundedWildcards() {
        A a = new A();
        B b = new B();
        C c = new C();

        Gen<A> w = new Gen<A>(a);
        Gen<B> w2 = new Gen<B>(b);
        Gen<C> w3 = new Gen<C>(c);
        // Допустимые вызовы метода test().
        test(w);
        test(w2);
        // Метод test() нельзя вызывать c w3,
        // потому что w3 не является объектом
        // класса, унаследованного от А.
        //test(w3);
    }

    static void test(Gen<? extends A> o) {

    }
}
