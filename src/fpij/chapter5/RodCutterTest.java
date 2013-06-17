package fpij.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static fpij.chapter5.TestHelper.assertThrows;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RodCutterTest {
    private RodCutter rodCutter;
    private static final List<Integer> prices = Arrays.asList(10, 20, 30);

    @Before
    public void setUp() {
        rodCutter =  new RodCutter();
    }

    @Test
    public void junit3Test() {
        try {
            rodCutter.setPrices(prices);
            rodCutter.maxProfit(0);
            fail("Expected exception for zero value for argument.");
        } catch (RodCutterException rce) {
            assertTrue("expected", true);
        }
    }

    @Test(expected = RodCutterException.class)
    public void junit4Test() throws RodCutterException {
        rodCutter.setPrices(prices);
        rodCutter.maxProfit(0);
    }

    // TODO: Need to email the author to ask why this won't compile due to error:
    // java: incompatible thrown types fpij.chapter5.RodCutterException in lambda expression
//    @Test
//    public void junitFutureVersionTest() {
//        rodCutter.setPrices(prices);
//        assertThrows(RodCutterException.class, () -> rodCutter.maxProfit(0));
//    }
}
