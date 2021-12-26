package coordinateCalculator.domain;

import java.util.HashSet;
import java.util.List;

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
}
