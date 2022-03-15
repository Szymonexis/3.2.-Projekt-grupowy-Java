package org.example;

public class MyExceptionThree extends Exception {

    private final String msg;

    MyExceptionThree(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.msg;
    }
}
