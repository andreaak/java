package test.interfaces;

@SuppressWarnings("unused")
public class TestInterface implements Interface, InterfacePackage {

	@Override
	public void Show() {
		int b = A;
		int a = InterfacePackage.B;

	}

	@Override
	public void Show1() {
	}

	@Override
	public boolean Tst() {
		// TODO Auto-generated method stub
		return false;
	}

}

@SuppressWarnings("unused")
abstract class  TestInterface2 implements Interface, InterfacePackage {

	@Override
	public void Show() {
		int a = InterfacePackage.B;
		int b = TestInterface.A;
	}

//	@Override
//	public void Show1() {
//		
//	}

}

//class TestInterface3 implements Interface, Interface3 {
//
//	public void Show() {
//		int b = A;
//		int a = InterfacePackage.B;
//
//	}
//
//	public int Show() {
//	}
//
//}
//
//class TestInterface4 implements Interface3, Interface4 {
//
//	public int Show() {
//	}
//
//	public long Show() {
//	}
//}


