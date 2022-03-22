package org.example;

public class PrimeNumberThread extends Thread {
    private int[] vals;
    private int index;

    PrimeNumberThread(int[] vals, int index) {
        this.vals = vals;
        this.index = index;
    }

    public void run() {
        int max = (int) Math.floor(Math.sqrt(vals[index]));
        for (int i = 2; i < max; i++) {
            if (vals[index] % i == 0) {
                vals[index] = 0;
            }
        }
    }
}
