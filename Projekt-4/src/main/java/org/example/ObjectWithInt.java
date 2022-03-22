package org.example;

public class ObjectWithInt {
    private int x = 0;
    public synchronized int test() {
        for (int i = 0; i < 10000; i++) {
            x++;
            x--;
        }
        return x;
    }
}
