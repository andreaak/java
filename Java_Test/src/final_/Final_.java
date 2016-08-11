package final_;

public class Final_ {

	public static final int a = 3;
	public static final int d;
	public final int b;
	public final int e;

	static
	{
		d= 5;
	}
	
	{
		e = 7;
	}
	
	public Final_(int c)
	{
		//d= 5;		
		b = c;
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		Final_ a = new Final_(2);
		System.out.println(a.a);
		System.out.println(a.b);
		Final_ a2 = new Final_(9);
		System.out.println(a2.a);
		System.out.println(a2.b);
	}
}
