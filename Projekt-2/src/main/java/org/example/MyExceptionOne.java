package org.example;

public class MyExceptionOne extends Exception {

    private final String msg;

    MyExceptionOne(String msg) {
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
