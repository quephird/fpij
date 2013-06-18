package fpij.chapter7;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Memoizer {
     public static <T,R> R callMemoized(final BiFunction<Function<T,R>, T, R> function, final T input) {
         Function<T,R> memoized = new Function<T,R>() {
             private final Map<T,R> store = new HashMap<>();

             public R apply(final T input) {
                 if (!store.containsKey(input))
                     store.put(input, function.apply(this, input));
                 return store.get(input);
             }
         };

         return memoized.apply(input);
     }
}
