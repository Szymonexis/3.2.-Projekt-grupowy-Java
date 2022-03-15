package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) {
        // exercise 1
        try {
            throw new Exception("Don't let your memes be dreams :3");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // exercise 2
        try {
            throw new MyExceptionOne("Don't let your memes be dreams :3");
        } catch (MyExceptionOne e) {
            System.out.println(e.getMsg());
        }

        // exercise 3
        ExceptionsTester exceptionsTester = new ExceptionsTester();
        try {
            exceptionsTester.getMyExceptionThrows();
        } catch (MyExceptionOne e) {
            System.out.println(e);
        }

        // exercise 4
        Object object = null;
        try {
            System.out.println(object.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        // exercise 5
        try {
            exceptionsTester.f("normal");
        } catch (MyExceptionTwo e) {
            System.out.println(e);
        }

        // exercise 6
        try {
            exceptionsTester.f("runtime");
        } catch (MyExceptionTwo | RuntimeException e) {
            System.out.println(e);
        }

        // exercise 7 & 12
        try {
            exceptionsTester.throwThreeExceptions();
        } catch (MyExceptionOne | MyExceptionTwo | MyExceptionThree e) {
            System.out.println(e);
        } finally {
            System.out.println("FINALLY WORKED!!!");
        }

        // exercise 8
        int[] intArray = new int[1];
        try {
            System.out.println(intArray[1]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // exercise 9
        Boolean continueLoop = true;
        Integer number = 0;
        while(continueLoop) {
            try {
                if (Math.random() > (1.0 / 6.0)) {
                    throw new MyExceptionOne("meme" + number++);
                }
                continueLoop = false;
            } catch (MyExceptionOne e) {
                System.out.println(e);
            }
        }

        // exercise 10
        C c = new C();
        A a = c;
        try {
            a.throwMyExceptionOne();
        } catch (MyExceptionOne e) {
            System.out.println(e);
        }
    }
}
