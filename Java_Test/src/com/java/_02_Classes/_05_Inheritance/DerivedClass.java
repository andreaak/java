package com.java._02_Classes._05_Inheritance;

/**
 * Наследование.
 */
public class DerivedClass extends BaseClass {

    public static int a = GetIntStatic("DerivedClass.Static var a");
    public int b = GetInt("DerivedClass.Var b");
    public int c = GetIntStatic("DerivedClass StaticMethod c");

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
        //super(e); Только static переменные класса могут быть переданы в конструктор с параметрами,
        //вызывающийся через слово super(//параметр//) или this(//параметр//)
        super(a);
        System.out.println("DerivedClass.Ctor2");
    }

    @Override
    public void method() {
        System.out.println("method from DerivedClass");
    }

    @Override
    public void method2() {
        // Вызов метода базового класса.
        super.method();
        System.out.println("method2 from DerivedClass");
    }

    public static void staticMethod() {
        System.out.println("staticMethod from DerivedClass");
    }

    private static int GetIntStatic(String text) {
        System.out.println(text);
        return 21;
    }

    private int GetInt(String text) {
        System.out.println(text);
        e = a;
        return 2;
    }

    @Override
    protected void InhTest() {// Access Modifier should be same or wider
    }

    @Override
    public void InhTest2() {
    }

    @Override
    public DerivedClass InhTest4() {// Can use subclass like return param - ковариантный возврат
        return new DerivedClass();
    }

//	@Override
//	protected Animal InhTest5() {
//		return new Animal(1);
//	}

//    @Override
//    protected void InhTest6(BaseClass b) {//Input class should be same like in base class
//
//    }

//    @Override
//    protected void InhTest7(DerivedClass b) {//Input class should be same like in base class
//
//    }
}
