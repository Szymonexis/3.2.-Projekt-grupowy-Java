package org.example;

public class ExceptionsTester {

    public void getMyExceptionThrows() throws MyExceptionOne {
        throw new MyExceptionOne("from getMyExceptionThrows()");
    }

    public void f(String mode) throws MyExceptionTwo, RuntimeException {
        switch(mode) {
            case "runtime":
                try {
                    this.g();
                } catch (MyExceptionOne e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    this.g();
                } catch (MyExceptionOne e) {
                    throw new MyExceptionTwo("thrown from f()");
                }
                break;
        }
    }

    public void g() throws MyExceptionOne {
        throw new MyExceptionOne("from inside g()");
    }

    public void throwThreeExceptions()
            throws MyExceptionOne, MyExceptionTwo, MyExceptionThree {
        switch((int) Math.round(Math.random() * 3)) {
            case 0:
                throw new MyExceptionOne("from throwThreeExceptions()");
            case 1:
                throw new MyExceptionTwo("from throwThreeExceptions()");
            case 2:
                throw new MyExceptionThree("from throwThreeExceptions()");
        }
    }
}
