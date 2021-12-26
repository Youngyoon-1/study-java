package coordinateCalculator.domain;

public class Line extends AbstractFigure {
    public Line(Points points) {
        super(points);
    }

    @Override
    public double area() {
        return points().calculate();
    }
}
