package test.exception;

class TstException1 extends Exception {
	
	private static final long serialVersionUID = 1L;
}

class TstException2 extends TstException1 {

	private static final long serialVersionUID = 385345702063283934L;
}

class TstException3 extends Exception {

	private static final long serialVersionUID = 3373827631216907287L;
}

class Tst1{
	public void TstMethod1() throws TstException1 {
		
	}
	
	public void TstMethod2() throws TstException1 {
		
	}
	
	public void TstMethod3() throws TstException2 {
		
	}
}

class Tst2 extends Tst1{
	
	@Override
	public void TstMethod1() throws TstException1 {
		
	}
	
	@Override
	public void TstMethod2() throws TstException2 {// can use successor exception
		
	}
	
//	@Override
//	public void TstMethod3() throws TstException1 {// can't use ancestor exception
//		
//	}

//	@Override
//	public void TstMethod1() throws TstException3 {//can't throws exception different that declared in super.method()
//		
//	}
}
