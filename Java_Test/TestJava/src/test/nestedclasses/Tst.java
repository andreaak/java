package test.nestedclasses;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@SuppressWarnings("unused")
@RunWith(JUnit4.class)
public class Tst {

	@Test
	public void test() {
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
		MyIncrement.f(c2);
		Caller callerl = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());
		callerl.go();
		callerl.go();
		caller2.go();
		caller2.go();
	}

}
