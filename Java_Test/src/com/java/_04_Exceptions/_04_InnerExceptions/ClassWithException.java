package com.java._04_Exceptions._04_InnerExceptions;

class ClassWithException {
    public void throwInner() throws Exception {
        throw new Exception("Это внутреннее исключение!");
    }

    public void catchInner() throws Exception {
        try {
            this.throwInner();
        } catch (Exception e) {
            throw new Exception("Это внешнее исключение!", e);
        }
    }
}

