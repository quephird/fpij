package fpij.chapter7;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static fpij.chapter7.Memoizer.callMemoized;

public class RodCutterBasic {
    private static final List<Integer> prices = Arrays.asList(2, 1, 1, 2, 2, 2, 2, 1, 8, 9, 15);

    public static void main(String[] args) {
        System.out.println("Computing maximum profits the lame way...");
        timeInvocations(RodCutterBasic::maxProfitPreJdk8, 5, 22);

        System.out.println("Computing maximum profits the uber way...");
        timeInvocations(RodCutterBasic::maxProfitJdk8, 5, 22);
    }

    public static int maxProfitPreJdk8(final int length) {
        int profit = (length <= prices.size()) ? prices.get(length - 1) : 0;
        for (int i = 1; i < length; i++) {
            int priceWhenCut = maxProfitPreJdk8(i) + maxProfitPreJdk8(length - i);
            if (profit < priceWhenCut)
                profit = priceWhenCut;
        }

        return profit;
    }

    public static int maxProfitJdk8(final int length) {
        return callMemoized((final Function<Integer, Integer> function, final Integer innerLength) -> {
            int profit = (innerLength <= prices.size()) ? prices.get(innerLength - 1) : 0;
            for (int i = 1; i < innerLength; i++) {
                int priceWhenCut = function.apply(i) + function.apply(innerLength - i);
                if (profit < priceWhenCut)
                    profit = priceWhenCut;
            }

            return profit;
        }, length);
    }

    private static void timeInvocations(Function<Integer,Integer> function, int... args) {
        long startingTime = System.currentTimeMillis();
        for (int arg : args) {
            System.out.println(function.apply(arg));
        }
        System.out.println("Time elapsed in seconds: " + (System.currentTimeMillis()-startingTime)/1000.0);
    }
}
