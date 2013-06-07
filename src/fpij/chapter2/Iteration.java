package fpij.chapter2;

import java.util.function.Consumer;

public class Iteration {
    public static void main(String[] args) {
        preJdk5();
        preJdk8();
        jdk8Lame();
        jdk8Uber();
    }

    private static void preJdk5() {
        System.out.println("Ugh... printing friends before JDK 5...");
        for (int i=0; i<Constants.FRIENDS.size(); i++) {
            System.out.println(Constants.FRIENDS.get(i));
        }
    }

    private static void preJdk8() {
        System.out.println("Ugh... printing friends before JDK 8...");
        for (String friend : Constants.FRIENDS) {
            System.out.println(friend);
        }
    }

    private static void jdk8Lame() {
        System.out.println("Ugh... printing friends the lame way in JDK 8...");
        Constants.FRIENDS.forEach(new Consumer<String>() {
            public void accept(final String name) {
                 System.out.println(name);
            }
        });
    }

    private static void jdk8Uber() {
        System.out.println("Printing friends with JDK 8 the uber way!");
        Constants.FRIENDS.forEach((final String name) -> System.out.println(name));
    }
}
