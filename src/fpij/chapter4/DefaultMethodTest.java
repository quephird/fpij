package fpij.chapter4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class DefaultMethodTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }

    // This is a horribly lame test, but none of the mocking libraries has caught up with JDK 8.
    @Test
    public void testWhoGetsCalled() {
        SeaPlane sp = new SeaPlane();
        sp.takeOff();
        assertTrue(outContent.toString().trim().contains("FastFly::takeOff"));
        sp.turn();
        assertTrue(outContent.toString().trim().contains("Vehicle::turn"));
        sp.cruise();
        assertTrue(outContent.toString().trim().contains("Sail::cruise"));
        sp.land();
        assertTrue(outContent.toString().trim().contains("Fly::land"));
    }
}
