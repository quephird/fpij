package fpij.chapter3;

public class Person {
    private final String name;
    private final int age;

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int ageDifference(final Person other) {
        return this.getAge() - other.getAge();
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }
}
