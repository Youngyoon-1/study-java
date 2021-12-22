package coordinateCalculator.domain;

import static coordinateCalculator.domain.Figure.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Points {
    public static final int DUPLICATION_COUNT = 2;
    public static final int REFERENCE_POINT_INDEX = 0;

    private final List<Point> points = new ArrayList<>();

    public Points(String input) {
        Arrays.stream(input.split(COORDINATE_DELIMITER)).forEach(s -> points.add(new Point(s)));
    }

    public boolean canMakeRectangle() {
        List<Integer> xValues = points.stream().map(Point::getX).collect(Collectors.toList());
        List<Integer> yValues = points.stream().map(Point::getY).collect(Collectors.toList());
        return xValues.stream().distinct().count() == DUPLICATION_COUNT
            && yValues.stream().distinct().count() == DUPLICATION_COUNT;
    }

    public List<Point> getWidthPoints() {
        int y = points.get(REFERENCE_POINT_INDEX).getY();
        return points.stream().filter(point -> point.getY() == y).collect(Collectors.toList());
    }

    public List<Point> getHeightPoints() {
        int x = points.get(REFERENCE_POINT_INDEX).getX();
        return points.stream().filter(point -> point.getX() == x).collect(Collectors.toList());
    }

    public List<Point> points() {
        return points;
    }
}
