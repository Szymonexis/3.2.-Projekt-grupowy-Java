package org.example;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) throws InterruptedException {
//        exerciseOne();
//        exerciseTwo();
//        exerciseThree();
        exerciseFour();
    }

    private static void exerciseOne() {
        ArrayList<CountingThread> arrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arrayList.add(new CountingThread());
        }

        for (int i = 0; i < 9; i++) {
            arrayList.get(i).start();
        }
    }

    private static void exerciseTwo() {
        SynchronizationThread array[] = new SynchronizationThread[10];

        ObjectWithInt object = new ObjectWithInt();

        for (int i = 0; i < 10; i++) {
            array[i] = new SynchronizationThread(object);
            array[i].start();
        }
    }

    private static void exerciseThree() throws InterruptedException {
        int array[] = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        AdditionalThread additionalThread = new AdditionalThread(array);
        additionalThread.start();
        additionalThread.join();

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }

        System.out.println("Array List = " + arrayList);
    }

    private static void exerciseFour() throws InterruptedException {
        String empty = "□";
        String current = "😎";
        int size = 10;

        boolean array[][] = new boolean[size][size];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = false;
            }
        }

        WalkingThread threads[] = new WalkingThread[size];

        for (int i = 0; i < array.length; i++) {
            threads[i] = new WalkingThread(array[i]);
            threads[i].start();
        }

        boolean isFinnished = false;
        while (!isFinnished) {
            String toPrint = "";
            boolean allTrue = true;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if (array[i][j]) {
                        toPrint += current;
                    } else {
                        toPrint += empty;
                    }
                    allTrue &= array[i][j];
                }
                toPrint += "\n";
            }
            isFinnished = allTrue;
            Thread.sleep(1000);
            System.out.println(toPrint);
        }
    }
}
