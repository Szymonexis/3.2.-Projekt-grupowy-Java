package org.example;

public class B extends A {

    B() {}

    @Override
    public void throwMyExceptionOne() throws MyExceptionOneChild {
        throw new MyExceptionOneChild("B.throwMyExceptionOne()");
    }
}
