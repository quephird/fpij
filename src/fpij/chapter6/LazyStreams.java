package fpij.chapter6;

import java.util.Arrays;
import java.util.List;

public class LazyStreams {
    public static void main(final String[] args) {
        List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe", "Mike",
                "Susan", "George", "Robert", "Julia", "Parker", "Benson");

        final String firstNameWithThreeLetters = names
                .stream()
                .filter(name -> length(name) == 3)
                .map(name -> toUpper(name))
                .findFirst()
                .get();

        System.out.println(firstNameWithThreeLetters);
    }

    private static int length(final String name) {
        System.out.println("Getting length for " + name + "...");
        return name.length();
    }

    private static String toUpper(final String name) {
        System.out.println("Uppercasing " + name + "...");
        return name.toUpperCase();
    }
}
