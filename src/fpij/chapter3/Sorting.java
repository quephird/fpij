package fpij.chapter3;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Sorting {
    public static void main(String[] args){
        jdk8Lame();
        jdk8NotAsLame();
        jdk8Uber();
        jdk8MoreUber();
    }

    private static void jdk8Lame() {
        List<Person> ascendingAge =
                Constants.PEOPLE
                        .stream()
                        .sorted((p1,p2) -> p1.ageDifference(p2))
                        .collect(toList());
        printPeople("People sorted by ascending age using lambda: ", ascendingAge);
    }

    private static void jdk8NotAsLame() {
        List<Person> ascendingAge =
                Constants.PEOPLE
                        .stream()
                        .sorted(Person::ageDifference)
                        .collect(toList());
        printPeople("People sorted by ascending age using method reference: ", ascendingAge);
    }

    private static final Comparator<Person> compareAscending = (p1,p2) -> p1.ageDifference(p2);
    // This differs from the text; it says to use reverseOrder(), but that yields a compile error.
    private static final Comparator<Person> compareDescending = compareAscending.reverse();

    private static void jdk8Uber() {
        List<Person> sortedPeople =
                Constants.PEOPLE
                        .stream()
                        .sorted(compareAscending)
                        .collect(toList());
        printPeople("People sorted by ascending age using a Comparator: ", sortedPeople);
        sortedPeople =
                Constants.PEOPLE
                        .stream()
                        .sorted(compareDescending)
                        .collect(toList());
        printPeople("People sorted by descending age using a Comparator: ", sortedPeople);
    }

    private static void printPeople(final String message, final List<Person> people){
        System.out.println(message);
        people.forEach(System.out::println);
    }

    private static final Function<Person, String> byName = person -> person.getName();
    private static final Function<Person, Integer> byAge = person -> person.getAge();

    private static void jdk8MoreUber() {
        List<Person> sortedPeople =
                Constants.PEOPLE
                        .stream()
                        .sorted(comparing(byAge).thenComparing(byName))
                        .collect(toList());
        printPeople("People sorted by ascending age then name using Comparators class: ", sortedPeople);
    }
}
