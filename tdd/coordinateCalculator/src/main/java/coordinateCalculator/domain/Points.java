package coordinateCalculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public double calculateLine() {
        return points.get(0).calculateDistance(points.get(1));
    }

    public boolean isInvalidPoints(int pointCount) {
        return pointCount != new HashSet<>(points).size();
    }

    private int getDifferenceX() {
        return points.stream()
            .map(Point::getX)
            .collect(Collectors.toSet())
            .stream()
            .reduce((a, b) -> a - b)
            .get();
    }

    private int getDifferenceY() {
        return points.stream()
            .map(Point::getY)
            .collect(Collectors.toSet())
            .stream()
            .reduce((a, b) -> a - b)
            .get();
    }

    public boolean canMakeRectangle() {
        Set<Integer> xCoordinates = points.stream().map(Point::getX).collect(Collectors.toSet());
        Set<Integer> yCoordinates = points.stream().map(Point::getY).collect(Collectors.toSet());

        return xCoordinates.size() == 2 && yCoordinates.size() == 2;
    }

    public double calculateRectangle() {
        return Math.abs(getDifferenceX() * getDifferenceY());
    }

    public double calculateTriangle() {
        double a = points.get(0).calculateDistance(points.get(1));
        double b = points.get(0).calculateDistance(points.get(2));
        double c = points.get(1).calculateDistance(points.get(2));

        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public boolean canMakeTriangle() {
        double a = points.get(0).calculateTilt(points.get(1));
        double b = points.get(0).calculateTilt(points.get(2));

        return a != b;
    }

    public int size() {
        return points.size();
    }

    public boolean hasPoint(Point point) {
        return points.contains(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Points points1 = (Points)o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
