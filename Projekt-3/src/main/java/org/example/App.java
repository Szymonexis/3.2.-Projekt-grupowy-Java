package org.example;

import java.util.function.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Exercise 1
        MyInterface myInterface = (x) -> x - 100;
        Integer result = myInterface.myMethod(4);
        System.out.println(result);

//        Exercise 2
        UnaryOperator<Integer> integerUnaryOperator = (Integer x) -> -x;
        System.out.println(integerUnaryOperator.apply(4));

        BinaryOperator<Integer> integerBinaryOperator = (Integer x, Integer y) -> x + y - 16;
        System.out.println(integerBinaryOperator.apply(3, 4));

        Consumer<Integer> integerConsumer = (Integer x) -> System.out.println(x + 5);
        integerConsumer.accept(6);

        Supplier<Integer> integerSupplier = () -> ((int) Math.floor(Math.random()));
        System.out.println(integerSupplier.get());

        Function<Integer, String> integerStringFunction = (Integer x) -> "Liczba" + x.toString();
        System.out.println(integerStringFunction.apply(5));

        Predicate<Integer> integerPredicate = (Integer x) -> x < 100;
        System.out.println(integerPredicate.test(100));

//        Exercise 3
        MyInterfaceCalc dodaj = Integer::sum;
        MyInterfaceCalc odejmij = (Integer x, Integer y) -> x - y;
        MyInterfaceCalc pomnoz = (Integer x, Integer y) -> x * y;
        MyInterfaceCalc podziel = (Integer x, Integer y) -> x / y;

        System.out.println("2 + 3 = " + Calculator.wykonaj(2, 3, dodaj));
        System.out.println("2 - 3 = " + Calculator.wykonaj(2, 3, odejmij));
        System.out.println("2 * 3 = " + Calculator.wykonaj(2, 3, pomnoz));
        System.out.println("2 / 3 = " + Calculator.wykonaj(2, 3, podziel));

    }
}
