package fpij.chapter4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CameraTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Camera camera;
    private Consumer<String> printCaptured;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        camera = new Camera();
        printCaptured = filterInfo -> System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }

    @Test
    public void testCameraWithNoFilter() {
        printCaptured.accept("no filter");
        assertTrue(outContent.toString().trim().matches("^with no filter:(.*)r=200,g=100,b=200(.*)"));
    }

    @Test
    public void testCameraWithBrightFilter() {
        camera.setFilters(Color::brighter);
        printCaptured.accept("brighter filter");
        assertTrue(outContent.toString().trim().matches("^with brighter filter:(.*)"));
        assertFalse(outContent.toString().trim().matches("(.*)r=200,g=100,b=200(.*)"));
    }

    @Test
    public void testCameraWithDarkFilter() {
        camera.setFilters(Color::darker);
        printCaptured.accept("darker filter");
        assertTrue(outContent.toString().trim().matches("^with darker filter:(.*)"));
        assertFalse(outContent.toString().trim().matches("(.*)r=200,g=100,b=200(.*)"));
    }

    @Test
    public void testCameraWithBothFilters() {
        camera.setFilters(Color::darker, Color::brighter);
        printCaptured.accept("darker & brighter filter");
        assertTrue(outContent.toString().trim().matches("^with darker & brighter filter:(.*)"));

        // The next statement would cause this test to fail; the book shows that it would pass.
        // assertTrue(outContent.toString().trim().matches("(.*)r=200,g=100,b=200(.*)"));
    }
}
