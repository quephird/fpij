package fpij.chapter5;

import static org.junit.Assert.fail;

public class TestHelper {
    public static <X extends Throwable> Throwable assertThrows(final Class<X> exceptionClass, final Runnable block) {
        try {
            block.run();
        } catch (Throwable t) {
            if (exceptionClass.isInstance(t)) {
                return t;
            }
        }

        fail("Failed to throw expected exception.");
        return null;
    }
}
