package com.java._02_Classes._05_Inheritance;

/**
 * Наследование.
 */
public class BaseClass {
    // Поля
    // Открытое поле.
    public String publicField = "BaseClass.publicField";

    // Закрытое поле.
    private String privateField = "BaseClass.privateField";

    // Защищенное поле.
    protected String protectedField = "BaseClass.protectedField";

    public static int a = GetIntSt("BaseClass. Static var a");
    public int b = GetInt("BaseClass. Var b");
    public int c = GetIntSt("BaseClass. Var c with StaticMethod");

    public int e;

    static{
        System.out.println("BaseClass.Static initializer");
    }

    {
        System.out.println("BaseClass.Initializer");
        e = 1;
    }

    public BaseClass(int a, int b) {
        System.out.println("BaseClass.Ctor2");
    }

    public BaseClass() {
        System.out.println("BaseClass.Ctor1");
    }

    // Метод
    public void show() {
        System.out.println(privateField);
    }

    public void method() {
        System.out.println("method from BaseClass");
    }

    public void method2() {
        // Вызов метода базового класса.
        System.out.println("method from DerivedClass");
    }

    public static void staticMethod() {
        System.out.println("staticMethod from BaseClass");
    }

    private static int GetIntSt(String text) {
        System.out.println(text);
        return 10;
    }

    private int GetInt(String text) {
        System.out.println(text);
        return 1;
    }

    void InhTest() {
    }

    protected void InhTest2() {
    }

    protected BaseClass InhTest4() {
        return new BaseClass();
    }

    protected BaseClass InhTest5() {
        return new BaseClass();
    }

    protected void InhTest6( DerivedClass b ) {
    }

    protected void InhTest7( BaseClass b ) {
    }
}
