package test.inheritance;


public class TestB extends TestA{
	
	public static int a = GetIntSt("B.Static var a");
	public int b = GetIntSt1("B.Var b");
	public int c = GetIntSt("B.Var c");
	public int d = GetIntSt2("B.Var d");

	public int e;
	
	static{
		System.out.println("B.Static initializer");
	}
	
	{
		System.out.println("B.Initializer");
		e = 2;
	}
	
	public TestB(int a)
	{
		super(a);
		System.out.println("B.Ctor2");
	}
	
	public TestB()
	{
		System.out.println("B.Ctor1");
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
	
	@Override
	protected void InhTest()
	{
	}
	
	@Override
	public void InhTest2()
	{
	}
	
	@Override
	public TestB InhTest4()
	{
		return new TestB();
	}
	
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
	
//	@Override
//	public TestD InhTest5()
//	{
//		return new TestD();
//	}
}
