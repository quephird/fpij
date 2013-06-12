package fpij.chapter4;

import java.util.function.Function;

public class CalculateNAV {
    private Function<String, Double> priceFinder;

    public CalculateNAV(Function<String, Double> priceFinder) {
        this.priceFinder = priceFinder;
    }

    public double computeStockWorth(final String ticker, final int shares) {
        return priceFinder.apply(ticker) * shares;
    }
}
