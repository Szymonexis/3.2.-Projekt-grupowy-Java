package org.example;

public class CountingThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("CountingThread " + i);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
