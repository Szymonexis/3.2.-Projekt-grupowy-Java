package org.example;

public class Calculator {
    static Integer wykonaj(Integer x, Integer y, MyInterfaceCalc myInterface) {
        return myInterface.method(x, y);
    }
}
