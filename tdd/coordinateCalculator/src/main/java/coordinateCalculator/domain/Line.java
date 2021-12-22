package coordinateCalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Line implements Figure {
    public static final int FIRST_COORDINATE_INDEX = 0;
    public static final int SECOND_COORDINATE_INDEX = 1;

    private final Point firstPoint;
    private final Point secondPoint;

    public Line(String input) {
        String[] coordinates = input.split(COORDINATE_DELIMITER);
        firstPoint = new Point(coordinates[FIRST_COORDINATE_INDEX]);
        secondPoint = new Point(coordinates[SECOND_COORDINATE_INDEX]);
    }

    public Line(List<Point> points) {
        firstPoint = points.get(FIRST_COORDINATE_INDEX);
        secondPoint = points.get(SECOND_COORDINATE_INDEX);
    }

    public double length() {
        int a = firstPoint.getX() - secondPoint.getX();
        int b = firstPoint.getY() - secondPoint.getY();
        return Math.sqrt(a * a + b * b);
    }

    @Override
    public Double calculate() {
        return this.length();
    }

    @Override
    public List<Point> coordinates() {
        List<Point> points = new ArrayList<>();
        points.add(firstPoint);
        points.add(secondPoint);
        return points;
    }

    @Override
    public String toString() {
        return "두 점 사이 거리는 ";
    }
}
