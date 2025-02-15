package com.java._06_Generics._04_Wildcards;

public class NumericFns<T extends Number> {
    T num;

    // Передать конструктору ссылку на числовой объект.
    public NumericFns( T n ) {
        num = n;
    }

    // Возвратить обратную величину,
    double reciprocal() {
        return 1 / num.doubleValue();
    }

    // Возвратить дробную часть,
    double fraction() {
        return num.doubleValue() - num.intValue();
    }

    public boolean absEqual( NumericFns<?> ob ) {
        return Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue());
    }
}