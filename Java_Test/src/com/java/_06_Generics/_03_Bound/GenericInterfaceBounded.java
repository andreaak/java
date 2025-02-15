package com.java._06_Generics._03_Bound;

/**
 * Ограничения параметров типа
 */
interface Interface1 { /* ... */

}

interface Interface2<U> { /* ... */
    U get();
}

interface Interface3<U> extends Interface1 { /* ... */
    U get();
}

class ClassImplementedInterfaces implements Interface1, Interface2<Object> {
    @Override
    public Object get() {
        return 4;
    }
}

// T extends Interface1 и T extends Interface2<Object>  -  Аргумент типа должен являться или реализовывать указанный интерфейс.
// Ограничивающий интерфейс также может быть универсальным.

class GenericClassInterfaceBounded1<T extends Interface1> { /* ... */
}

class GenericClassInterfaceBounded2<T extends Interface2<Object>> { /* ... */
    T t;

    GenericClassInterfaceBounded2(T item) {
        t = item;
    }

    public Object getGeneric(){
        return t.get();
    }
}
