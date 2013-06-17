package fpij.chapter6;

public class HeavyCreation {
    public static void main(String[] args) {
        preJdk8Naive();
        preJdk8Imperfect();
        jdk8();
    }

    private static void preJdk8Naive() {
        System.out.println("Lazy loading the naive way...");
        final HolderNaive holder = new HolderNaive();
        System.out.println("Deferring Heavy creation...");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());
    }

    private static void preJdk8Imperfect() {
        System.out.println("Lazy loading a better but imperfect way...");
        final HolderBetterButNotPerfect holder = new HolderBetterButNotPerfect();
        System.out.println("Deferring Heavy creation...");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());
    }

    private static void jdk8() {
        System.out.println("Lazy loading in JDK8...");
        final Holder holder = new Holder();
        System.out.println("Deferring Heavy creation...");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());
    }
}
