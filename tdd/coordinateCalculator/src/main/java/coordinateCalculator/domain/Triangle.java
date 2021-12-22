package coordinateCalculator.domain;

import java.util.List;

public class Triangle implements Figure {

    private final Line lineOne;
    private final Line lineTwo;
    private final Line lineThree;
    private final Points points;

    public Triangle(String input) {
        points = new Points(input);
        lineOne = calculateLineOne();
        lineTwo = calculateLineTwo();
        lineThree = calculateLineThree();
    }

    private Line calculateLineThree() {
        return new Line(points.points().get(1), points.points().get(2));
    }

    private Line calculateLineTwo() {
        return new Line(points.points().get(0), points.points().get(2));
    }

    private Line calculateLineOne() {
        return new Line(points.points().get(0), points.points().get(1));
    }

    @Override
    public Double calculate() {
        double a = lineOne.length();
        double b = lineTwo.length();
        double c = lineThree.length();
        double s =  (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public List<Point> coordinates() {
        return points.points();
    }
}