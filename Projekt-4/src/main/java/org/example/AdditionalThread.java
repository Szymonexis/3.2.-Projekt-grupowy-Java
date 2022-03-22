package org.example;

public class AdditionalThread extends Thread {
    int[] array;

    AdditionalThread(int[] array) {
        this.array = array;
    }

    public void run() {
        PrimeNumberThread primeNumberThreads[] = new PrimeNumberThread[array.length];

        for (int i = 0; i < array.length; i++) {
            primeNumberThreads[i] = new PrimeNumberThread(array, i);
            primeNumberThreads[i].start();
        }
    }
}
