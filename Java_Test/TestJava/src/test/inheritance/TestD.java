package test.inheritance;


public class TestD{
	
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
		e = 3;
	}
	
	public TestD(int a)
	{
		System.out.println("B.Ctor2");
	}
	
	public TestD()
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

}
