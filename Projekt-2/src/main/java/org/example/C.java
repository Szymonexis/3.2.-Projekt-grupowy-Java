package org.example;

public class C extends B {

    @Override
    public void throwMyExceptionOne() throws MyExceptionOneChild {
        throw new MyExceptionOneChildChild("C.throwMyExceptionOne()");
    }
}
