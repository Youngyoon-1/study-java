package coordinateCalculator.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum FigureMapper {
    LINE(2, Line::new),
    RECTANGLE(4, Rectangle::new),
    TRIANGLE(3, Triangle::new);

    private final int pointCount;
    private final Function<String, Figure> function;

    FigureMapper(int pointCount, Function<String, Figure> function) {
        this.pointCount = pointCount;
        this.function = function;
    }

    public static Figure map(String input, int coordinateCount) {
        return Arrays.stream(FigureMapper.values())
            .filter(mapper -> mapper.isSameCount(coordinateCount))
            .findFirst()
            .get()
            .function.apply(input);
    }

    private boolean isSameCount(int coordinateCount) {
        return this.pointCount == coordinateCount;
    }
}
