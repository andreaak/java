package com.java.nestedclasses;

@SuppressWarnings("unused")
public class OuterClass {
	private int a = 0;
	private static int b = 0;
	
	public OuterClass()
	{
		//System.out.println("Ctor1");
	}
	
	public OuterClass(int a, double b)
	{
		new NestedClass();
	}
	
	public class InnerClass
	{
		public void Test()
		{
			a++;
			b++;
		}
	}	
	
	private class InnerClassPrivate
	{
	}
	
	class InnerClassDef
	{
	}
	
	protected class InnerClassProtected
	{
	}
	

	
	public static class NestedClass
	{
		public void Test(OuterClass o)
		{
			//a++;
			o.a++;
			b++;
		}
	}	
	
	private static class NestedClassPrivate
	{
	}
	
	static class NestedClassDef
	{
	}	
	
	protected static class NestedClassProtected
	{
	}	
}


interface Incrementable {
	void increment();
}

// Простая реализация интерфейса:
class Callee1 implements Incrementable {
	private int i = 0;

	public void increment() {
		i++;
		System.out.println(i);
	}
}

class MyIncrement {
	public void increment() {
		System.out.println("Другая операция");
	};

	public static void f(MyIncrement mi) {
		mi.increment();
	}
}

// Если класс должен вызывать метод increment()
// по-другому, необходимо использовать внутренний класс:
class Callee2 extends MyIncrement {
	private int i = 0;

	public void increment() {//???/
		super.increment();
		i++;
		System.out.println(i);
	}

	public void decrement() {
		super.increment();
		i--;
		System.out.println(i);
	}
	
	private class Closure implements Incrementable {
		public void increment() {
			// Указывается метод внешнего класса;
			// в противном случае возникает бесконечная рекурсия.
			Callee2.this.decrement();
		}
	}

	Incrementable getCallbackReference() {
		return new Closure();
	}
}

class Caller {
	private Incrementable callbackReference;

	Caller(Incrementable cbh) {
		callbackReference = cbh;
	}

	void go() {
		callbackReference.increment();
	}
}

class Callbacks {
//	public static void main(String[] args) {
//		Callee1 c1 = new Callee1();
//		Callee2 c2 = new Callee2();
//		MyIncrement.f(c2);
//		Caller callerl = new Caller(c1);
//		Caller caller2 = new Caller(c2.getCallbackReference());
//		callerl.go();
//		callerl.go();
//		caller2.go();
//		caller2.go();
//	}
}
