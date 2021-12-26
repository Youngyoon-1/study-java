package coordinateCalculator.domain;

public class Rectangle extends AbstractFigure {
    public Rectangle(Points points) {
        super(points);
    }

    @Override
    public double area() {
        return Math.abs(points().getDifferenceX() *  points().getDifferenceY());
    }

    @Override
    public void checkValidPoints(Points points) {
    }
}
