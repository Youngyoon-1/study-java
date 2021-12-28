package coordinateCalculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final Map<Integer, Function<Points, Figure>> classifier = new HashMap<>();
    public static final String ERROR_INVALID_POINTS = "[ERROR] 유효하지 않은 점입니다.";

    static {
        classifier.put(2, Line::new);
        classifier.put(3, Triangle::new);
        classifier.put(4, Rectangle::new);
    }

    public static Figure create(Points points) {
        Function<Points, Figure> function = classifier.get(points.size());
        if (function != null) {
            return function.apply(points);
        }
        throw new IllegalArgumentException(ERROR_INVALID_POINTS);
    }
}
