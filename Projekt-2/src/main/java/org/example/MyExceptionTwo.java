package org.example;

public class MyExceptionTwo extends Exception {

    private final String msg;

    MyExceptionTwo(String msg) {
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
