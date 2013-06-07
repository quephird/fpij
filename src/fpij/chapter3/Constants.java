package fpij.chapter3;

import java.util.Arrays;
import java.util.List;

public interface Constants {
    public static final List<Person> PEOPLE = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35));
}
