package fpij.chapter7;

import java.math.BigInteger;

import static fpij.chapter7.TailCalls.call;
import static fpij.chapter7.TailCalls.done;

public class Factorial {
    public static void main(final String[] args) {
        System.out.println("Computing factorials pre JDK8...");
        try {
            System.out.println("5! = " + factorialPreJdk8(5));
            System.out.println("20000! = " + factorialPreJdk8(20000));
        } catch (StackOverflowError so) {
            System.out.println("I'm sorry, Dave... I'm afraid I can't do that.");
        }

        System.out.println("Computing factorials using JDK8 but failing...");
        System.out.println("5! = " + factorialJdk8Fail(5));
        System.out.println("20000! = " + factorialJdk8Fail(20000));

        System.out.println("Computing factorials using JDK8 the right way...");
        System.out.println("5! = " + factorialJdk8Uber(5));
        System.out.println("20000! = " + factorialJdk8Uber(20000));
    }

    private static int factorialPreJdk8(final int number) {
        if (number == 1)
            return number;
        else
            return number*factorialPreJdk8(number-1);
    }

    private static int factorialJdk8Fail(final int number) {
        return factorialJdk8FailHelper(1, number).invoke();
    }

    private static TailCall<Integer> factorialJdk8FailHelper(final int factorial, final int number) {
        if (number == 1)
            return done(factorial);
        else
            return call(() -> factorialJdk8FailHelper(factorial * number, number - 1));
    }

    private static BigInteger factorialJdk8Uber(final int number) {
        return factorialJdk8UberHelper(BigInteger.ONE, new BigInteger(new Integer(number).toString())).invoke();
    }

    private static TailCall<BigInteger> factorialJdk8UberHelper(final BigInteger factorial, final BigInteger number) {
        if (number.equals(BigInteger.ONE))
            return done(factorial);
        else
            return call(() -> factorialJdk8UberHelper(factorial.multiply(number), number.subtract(BigInteger.ONE)));
    }
}
