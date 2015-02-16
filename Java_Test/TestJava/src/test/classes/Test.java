package test.classes;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import test.classes.subclasses.SubTest;

@RunWith(JUnit4.class)
@SuppressWarnings({"unused", "static-access"})
public class Test {

	protected int a  =0;
	public static void main(String[] args) {
		Test tst = new Test();
		SubTest subTest = new SubTest();
		tst.tst4();
	}

	@org.junit.Test
	public void tst1() {
		int c  = new Test4().a;
		Assert.assertEquals(c, 0);
	}
	
	
	private boolean tst1(int a) {
		int b  = Test4.a;
		int c  = new Test4().a;
		return true;
	}
	
	private void tst4() {
		Test4 cl3 = new Test4();
		System.out.println("---");
		Test4 cl4 = new Test4(1);
	}
	

	
	protected void tst()
	{
	}
}

@SuppressWarnings("unused")
class Test4
{
	static int a = 1; 
	
	public Test4()
	{
		Test tst = new Test();
		int b = tst.a;
	}

	public Test4(int i) {
	}
}

abstract class Test3 extends Test4//can extends non abstract class
{
	static int a = 1; 
	
	public void Tst() {
		
	}
}


//Illegal modifier for the class Test5; only public, abstract & final are permitted
//static class Test5
//{
//	
//}