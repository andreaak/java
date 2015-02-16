package test.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Tst {

	@Test
	public void test() {
		try {
			System.out.println("Try");
			System.exit(0);
		} catch (Exception ex) {
			System.out.println("Catch");
		} catch (Error ex) {
			System.out.println("Error");
		}finally {
			System.out.println("Finaly");
		}
	}
}

