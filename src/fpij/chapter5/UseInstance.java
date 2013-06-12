package fpij.chapter5;

@FunctionalInterface
public interface UseInstance<T, E extends Throwable> {
    void accept(T instance) throws E;
}
