package fpij.chapter2;

import java.util.Optional;

public class Finding {
    public static void main(String[] args) {
        findPreJdk8("N");
        findPreJdk8("Z");
        findJdk8("N");
        findJdk8("Z");
    }

    private static void findPreJdk8(String letter) {
        System.out.println("Finding the first name that begins with " + letter + " before JDK8...");
        String result = null;
        for (String name : Constants.FRIENDS) {
            if (name.startsWith(letter)) {
                result = name;
                break;
            }
        }
        if (result != null) {
            System.out.println("Result: " + result);
        } else {
            System.out.println("No name found. :(");
        }
    }

    private static void findJdk8(String letter) {
        System.out.println("Finding the first name that begins with " + letter + " with JDK8...");
        Optional<String> result = Constants.FRIENDS
                .stream()
                .filter(Filtering.startsWithLetter(letter))
                .findFirst();
        System.out.println(String.format("Result: %s", result.orElse("No name found. :(")));
    }
}
