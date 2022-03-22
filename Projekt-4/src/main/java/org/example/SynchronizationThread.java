package org.example;

public class SynchronizationThread extends Thread {
    private ObjectWithInt objectWithInt;

    SynchronizationThread(ObjectWithInt object) {
        this.objectWithInt = object;
    }

    public void run() {
        System.out.println("SynchronizationThread " + objectWithInt.test());
    }
}
