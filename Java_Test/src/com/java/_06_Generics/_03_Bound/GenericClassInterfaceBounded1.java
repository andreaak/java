package com.java._06_Generics._03_Bound;

/**
 * Ограничения параметров типа
 */
interface Interface1 { /* ... */
}

interface Interface2<U> { /* ... */
}

class ClassImplementedInterfaces implements Interface1, Interface2<Object> { /* ... */
}

// T extends Interface1 и T extends Interface2<Object>  -  Аргумент типа должен являться или реализовывать указанный интерфейс.
// Ограничивающий интерфейс также может быть универсальным.

class GenericClassInterfaceBounded1<T extends Interface1> { /* ... */
}

class GenericClassInterfaceBounded2<T extends Interface2<Object>> { /* ... */
}
