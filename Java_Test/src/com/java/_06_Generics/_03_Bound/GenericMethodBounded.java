package com.java._06_Generics._03_Bound;

public class GenericMethodBounded {
    static <T extends Base> T testBounded(T obj) {
        return obj;
    }
}
