package fpij.chapter4;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public class Camera {
    private Function<Color, Color> filter;

    public Camera() {
        this.setFilters();
    }

    public void setFilters(final Function<Color, Color>... filters) {
        filter = Arrays.asList(filters)
                .stream()
                .reduce((f1, f2) -> f1.compose(f2))
                .orElse(color -> color);
    }

    public Color capture(final Color inputColor) {
        final Color processedColor = filter.apply(inputColor);
        return processedColor;
    }
}
