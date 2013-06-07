package fpij.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Filtering {
    private static final Predicate<String> startsWithN = name -> name.startsWith("N");
    private static final Predicate<String> startsWithB = name -> name.startsWith("B");

    private static final Function<String, Predicate<String>> startsWithLetter =
            letter -> name -> name.startsWith(letter);

    public static void main(String[] args) {
        preJdk8();
        jdk8();
        jdk8Uber();
        jdk8MoreUber();
        jdk8EvenMoreUber();
    }

    public static Predicate<String> startsWithLetter(final String letter) {
        return name -> name.startsWith(letter);
    }

    private static void preJdk8() {
        System.out.println("Filtering names before JDK8...");
        System.out.print("Count of names beginning with N: ");
        final List<String> startsWithN = new ArrayList<String>();
        for (String name : Constants.FRIENDS) {
            if (name.startsWith("N")) {
                startsWithN.add(name.toUpperCase());
            }
        }
        System.out.println(startsWithN.size());
    }

    private static void jdk8() {
        System.out.println("Filtering names with JDK8 the non-uber way...");
        System.out.print("Count of names beginning with N: ");
        int startsWithNCount =
                Constants.FRIENDS
                        .stream()
                        .filter(name -> name.startsWith("N"))
                        .toArray()
                        .length;
        System.out.println(startsWithNCount);
    }

    private static void jdk8Uber() {
        System.out.println("Filtering names with JDK8 the uber way...");
        System.out.print("Count of names beginning with N: ");
        int startsWithCount =
                Constants.FRIENDS
                        .stream()
                        .filter(startsWithN)
                        .toArray()
                        .length;
        System.out.println(startsWithCount);
        System.out.print("Count of names beginning with B: ");
        startsWithCount =
                Constants.FRIENDS
                        .stream()
                        .filter(startsWithB)
                        .toArray()
                        .length;
        System.out.println(startsWithCount);
    }

    private static void jdk8MoreUber() {
        System.out.println("Filtering names with JDK8 in a slightly more uber way...");
        System.out.print("Count of names beginning with N: ");
        int startsWithCount =
                Constants.FRIENDS
                        .stream()
                        .filter(startsWithLetter("N"))
                        .toArray()
                        .length;
        System.out.println(startsWithCount);
        System.out.print("Count of names beginning with B: ");
        startsWithCount =
                Constants.FRIENDS
                        .stream()
                        .filter(startsWithLetter("B"))
                        .toArray()
                        .length;
        System.out.println(startsWithCount);
    }

    private static void jdk8EvenMoreUber() {
        System.out.println("Filtering names with JDK8 in an even more uber way...");
        System.out.print("Count of names beginning with N: ");
        int startsWithCount =
                Constants.FRIENDS
                        .stream()
                        .filter(startsWithLetter.apply("N"))
                        .toArray()
                        .length;
        System.out.println(startsWithCount);
        System.out.print("Count of names beginning with B: ");
        startsWithCount =
                Constants.FRIENDS
                        .stream()
                        .filter(startsWithLetter.apply("B"))
                        .toArray()
                        .length;
        System.out.println(startsWithCount);
    }
}
