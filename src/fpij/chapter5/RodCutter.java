package fpij.chapter5;

import java.util.List;

public class RodCutter {
    private List<Integer> prices;

    public int maxProfit(int arg) throws RodCutterException {
        if (arg == 0) {
            throw new RodCutterException("You can't do that!!!");
        }
        return 0;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }
}
