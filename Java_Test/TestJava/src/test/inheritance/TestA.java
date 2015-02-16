package test.inheritance;

public class TestA {
	
	public static int a = GetIntSt("A.Static var a");
	public int b = GetIntSt1("A.Var b");
	public int c = GetIntSt("A.Var c");
	public int d = GetIntSt2("A.Var d");

	public int e;
	
	static{
		System.out.println("A.Static initializer");
	}
	
	{
		System.out.println("A.Initializer");
		e = 1;
	}
	
	public TestA(int a)
	{
		System.out.println("A.Ctor2");
	}
	
	public TestA()
	{
		System.out.println("A.Ctor1");
	}
	
	
	private static int GetIntSt(String text) {
		System.out.println(text);
		return 0;
	}

	private int GetIntSt1(String text) {
		System.out.println(text);
		return 0;
	}
	
	private int GetIntSt2(String text) {
		System.out.println(text);
		return e;
	}
	
	void InhTest()
	{
	}
	
	
	protected void InhTest2()
	{
	}
	
	protected TestA InhTest4()
	{
		return new TestA();
	}
	
	protected TestA InhTest5()
	{
		return new TestA();
	}
	
	protected void InhTest6(TestB b)
	{
	}
	
	protected void InhTest7(TestA b)
	{
	}
}
