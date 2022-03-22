package org.example;

public class WalkingThread extends Thread {
    boolean array[];

    WalkingThread(boolean[] array) {
        this.array = array;
    }

    public void run() {
        for (int i = 0; i < array.length; i++) {
            try {
                Thread.sleep((long) (Math.random() * 2000));
                array[i] = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
