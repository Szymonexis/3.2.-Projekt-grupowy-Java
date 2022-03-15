package org.example;

public class A {

    A() {};

    A(String text) throws MyExceptionTwo {
        System.out.println(text);
        throw new MyExceptionTwo("from A constructor");
    }

    public void throwMyExceptionOne() throws MyExceptionOne {
        throw new MyExceptionOne("from A.throwMyExceptionOne()");
    }
}
