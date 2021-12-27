package coordinateCalculator.domain;

public class Triangle extends AbstractFigure {
    Triangle(Points points) {
        super(points);
    }

    @Override
    public double area() {
        return points().calculateTriangle();
    }

    @Override
    public void checkValidPoints(Points points) {

    }
}
