package interfaces;

public interface InterfaceInheritance extends Interface, Interface2 {
	void tst1();
}

//interface ITest2 extends Test { can't be inherited from Class
//
//}

//interface ITest2 extends Test1 { //can't be inherited from Class
//
//}

interface ITest2 extends ITest {
	void Tst5();
}

class Test {

}


abstract class Test1 {

}

abstract class Test2 implements InterfaceInheritance {

}

class Test3 implements InterfaceInheritance {

	@Override
	public void Show() {
		
	}

	@Override
	public void tst1() {
		
	}

}