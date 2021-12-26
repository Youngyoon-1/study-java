package coordinateCalculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public double calculate() {
        return points.get(0).calculateDistance(points.get(1));
    }

    public boolean isInvalidPoints(int pointCount) {
        return pointCount != new HashSet<>(points).size();
    }

    public int getDifferenceX() {
        return points.stream()
            .map(Point::getX)
            .collect(Collectors.toSet())
            .stream()
            .reduce((a, b) -> a - b)
            .get();
    }

    public int getDifferenceY() {
        return points.stream()
            .map(Point::getY)
            .collect(Collectors.toSet())
            .stream()
            .reduce((a, b) -> a - b)
            .get();
    }
}
