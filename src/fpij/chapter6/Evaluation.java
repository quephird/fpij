package fpij.chapter6;

import java.util.function.Supplier;

public class Evaluation {
    public static void main(String[] args) {
        preJdk8(evaluate(1), evaluate(2));
        jdk8(() -> evaluate(1), () -> evaluate(2));
    }

    private static void preJdk8(final boolean i1, final boolean i2) {
        System.out.println("Eagerly evaluating expression...");
        System.out.println("Result: " + (i1 && i2));
    }

    private static void jdk8(final Supplier<Boolean> i1, final Supplier<Boolean> i2) {
        System.out.println("Lazily evaluating expression...");
        System.out.println("Result: " + (i1.get() && i2.get()));
    }

    public static boolean evaluate(final int value) {
        System.out.println("Evaluating input... " + value);
        simulateTimeConsumingOp(2000);
        return value > 100;
    }

    private static void simulateTimeConsumingOp(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (Exception e) {
        }
    }
}
