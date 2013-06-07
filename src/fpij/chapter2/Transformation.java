package fpij.chapter2;

import java.util.ArrayList;
import java.util.List;

public class Transformation {
    public static void main(String[] args) {
        preJdk8();
        jdk8Lame();
        jdk8Uber();
    }

    private static void preJdk8() {
        System.out.println("Uppercasing names before JDK8...");
        final List<String> uppercaseNames = new ArrayList<String>();
        for(String name : Constants.FRIENDS) {
            uppercaseNames.add(name.toUpperCase());
        }
        System.out.println(uppercaseNames);
    }

    private static void jdk8Lame() {
        System.out.println("Uppercasing names with JDK8 the lame way...");
        final List<String> uppercaseNames = new ArrayList<String>();
        Constants.FRIENDS.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        System.out.println(uppercaseNames);
    }

    private static void jdk8Uber() {
        System.out.println("Uppercasing names with JDK8 the uber way...");
        Constants.FRIENDS
            .stream()
            .map(name -> name.toUpperCase())
            .forEach(name -> System.out.print(name + " "));
    }
}
