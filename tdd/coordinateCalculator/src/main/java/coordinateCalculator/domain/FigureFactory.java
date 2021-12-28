package coordinateCalculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    public static final String ERROR_INVALID_POINTS = "[ERROR] 유효하지 않은 점입니다.";
    private static final Map<Integer, Function<Points, Figure>> classifier = new HashMap<>();

    static {
        classifier.put(Line.POINT_COUNT, Line::new);
        classifier.put(Triangle.POINT_COUNT, Triangle::new);
        classifier.put(Rectangle.POINT_COUNT, Rectangle::new);
    }

    public static Figure create(Points points) {
        Function<Points, Figure> function = classifier.get(points.size());
        if (function != null) {
            return function.apply(points);
        }
        throw new IllegalArgumentException(ERROR_INVALID_POINTS);
    }
}
