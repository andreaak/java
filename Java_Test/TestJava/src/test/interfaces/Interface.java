package test.interfaces;

public interface Interface {
	int A = 1;
	void Show();//by defalt Show is public and abstract
}

interface InterfacePackage {
	public static final int B = 2;
	void Show1();
	boolean Tst();
}

interface Interface3{
	int C = 3;
	int Show();
}

interface Interface4{
	int C = 3;
	long Show();
}

interface ITest {
	public void Tst();
	//protected void Tst2();
	public abstract void Tst3();
	void Tst4();//by defalt Tst4 is public and abstract
}