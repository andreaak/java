package test.inheritance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@SuppressWarnings("unused")
@RunWith(JUnit4.class)
public class Tst {

	@Test
	public void test() {
		TestB b = new TestB();
		System.out.println("------------------");
		TestB b2 = new TestB(1);
	}

}
