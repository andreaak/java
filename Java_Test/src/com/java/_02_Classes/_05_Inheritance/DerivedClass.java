package com.java._02_Classes._05_Inheritance;

/**
 * Наследование.
 */
public class DerivedClass extends BaseClass {

    public static int a = GetIntSt("DerivedClass.Static var a");
    public int b = GetInt("DerivedClass.Var b");
    public int c = GetIntSt("DerivedClass StaticMethod c");

    public int e;

    static {
        System.out.println("DerivedClass.Static initializer");
    }

    {
        System.out.println("DerivedClass.Initializer");
        e = 2;
    }

    // Пользовательский конструктор.
    // При создании объекта производного класса, конструктор производного класса
    // автоматически вызывает конструктор по умолчанию из базового класса.
    // Конструктор базового класса, присвоит всем данным какие-то свои безопасные значения.
    // После этого начнет работу конструктор производного класса, который повторно
    // будет определять значения для унаследованых членов. (ДВОЙНАЯ РАБОТА)!
    public DerivedClass() {
        // Изменяем все доступные поля унаследованные от базового класса.
        publicField = "DerivedClass.publicField";
        protectedField = "DerivedClass.protectedField";
        System.out.println("DerivedClass.Ctor1");
    }

    // пользовательский конструктор.
    // вызывается пользовательский конструктор базового класса, при этом не нужно,
    // присваивать значения, унаследованным членам в конструкторе производного класса.
    public DerivedClass(int a) {
        super(a);
        System.out.println("DerivedClass.Ctor2");
    }

    public void method() {
        System.out.println("method from DerivedClass");
    }

    public static void staticMethod() {

        System.out.println("staticMethod from DerivedClass");
    }

    private static int GetIntSt(String text) {
        System.out.println(text);
        return 21;
    }

    private int GetInt(String text) {
        System.out.println(text);
        return 2;
    }

    @Override
    protected void InhTest() {
    }

    @Override
    public void InhTest2() {
    }

    @Override
    public DerivedClass InhTest4() {
        return new DerivedClass();
    }

//	@Override
//	protected BaseClass InhTest5()
//	{
//		return new BaseClass();
//	}

//	@Override
//	protected void InhTest6(TestA b)
//	{
//
//	}
//
//	@Override
//	protected void InhTest7(TestB b)
//	{
//
//	}
}
