package coordinateCalculator.domain;

import java.util.List;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public double calculate() {
        return points.get(0).calculateDistance(points.get(1));
    }
}
