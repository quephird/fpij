package fpij.chapter2;

import java.util.Optional;

public class Reduction {
    public static void main(String[] args) {
        sumPreJdk8();
        sumJdk8();
        longestJdk8();
    }

    private static void sumPreJdk8() {
        System.out.println("Total number of characters before JDK8...");
        int sum = 0;
        for (String name : Constants.FRIENDS) {
            sum = sum + name.length();
        }
        System.out.println(sum);
    }

    private static void sumJdk8() {
        // For some reason, Stream.sum() is not available with build 92
        System.out.println("Total number of characters with JDK8...");
        final int sum = Constants.FRIENDS
                .stream()
                .map(name -> name.length())
                .reduce(0, (a,b) -> a+b);
        System.out.println(sum);
    }

    private static void longestJdk8() {
        System.out.println("A longest name with JDK8...");
        final Optional<String> longest = Constants.FRIENDS
                .stream()
                .reduce((n1, n2) -> n1.length()>=n2.length() ? n1 : n2);
        longest.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));
    }
}
