package fpij.chapter4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculateNAVTest {
    @Test
    public void testComputeStockWorthWithSimpleLambda() {
        final CalculateNAV calculateNAV = new CalculateNAV(ticker -> 6.01);
        assertEquals(6010.00, calculateNAV.computeStockWorth("GOOG", 1000), 0.001);
    }

    @Test
    public void testComputeStockWorthWithRealImplementation() {
        final CalculateNAV calculateNAV = new CalculateNAV(YahooFinance::getPrice);
        double googleWorth = calculateNAV.computeStockWorth("GOOG", 1000);
        assertNotNull(googleWorth);
    }
}
