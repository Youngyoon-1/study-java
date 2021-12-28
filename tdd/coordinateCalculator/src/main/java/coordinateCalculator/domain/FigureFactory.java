package coordinateCalculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final Map<Integer, Function<Points, Figure>> classifier = new HashMap<>();

    static {
        classifier.put(2, Line::new);
        classifier.put(3, Triangle::new);
        classifier.put(4, Rectangle::new);
    }

    public static Figure create(Points points) {
        return classifier.get(points.size()).apply(points);
    }
}
