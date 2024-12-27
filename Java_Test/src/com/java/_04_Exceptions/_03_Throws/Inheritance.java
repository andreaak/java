package com.java._04_Exceptions._03_Throws;

class BaseClass{
	public void TstMethod1() throws ExceptionBase {
		
	}
	
	public void TstMethod2() throws ExceptionBase {
		
	}
	
	public void TstMethod3() throws ExceptionDerived {
		
	}

	public void TstMethod4() throws ExceptionBase {

	}
}

class DerivedClass extends BaseClass{
	
	@Override
	public void TstMethod1() throws ExceptionBase {

	}
	
	@Override
	public void TstMethod2() throws ExceptionDerived {// can use successor exception
		
	}
	
//	@Override
//	public void TstMethod3() throws ExceptionBase {// can't use ancestor exception
//
//	}

//	@Override
//	public void TstMethod4() throws ExceptionOther {//can't throws exception different that declared in super.method()
//
//	}
}
