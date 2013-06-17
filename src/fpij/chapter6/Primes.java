package fpij.chapter6;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.IntStream;

public class Primes {
    public static void main(final String[] args) {
        System.out.println("The first ten primes are: " + primes(1, 10));
        System.out.println("The next five primes after 100 are: " + primes(100, 5));
    }

    public static List<Integer> primes(final int fromNumber, final int count) {
        // Another deviation from the book: IntStream.collect() takes _three_ arguments not just one like Stream.collect();
        // you must provide a lambda to create an initial collection, one to add elements to each collection,
        // and a third to combine collections.
        return IntStream
                .iterate(nextPrime(fromNumber), Primes::nextPrime)
                .limit(count)
                .collect(() -> new ArrayList<Integer>(), (coll, elt) -> coll.add(elt), (coll1, coll2) -> coll1.addAll(coll2));
    }

    public static boolean isPrime(final int number) {
        // Apparently Stream.intRange() has been moved to IntStream.range() as of b92.
        return (number > 1) &&
                IntStream
                        .range(2, (int)Math.sqrt(number)+1)
                        .noneMatch(divisor -> number % divisor == 0);
    }

    public static int nextPrime(final int number) {
        final int nextNumber = number + 1;
        if (isPrime(nextNumber))
            return nextNumber;
        else
            return nextPrime(nextNumber);
    }
}
