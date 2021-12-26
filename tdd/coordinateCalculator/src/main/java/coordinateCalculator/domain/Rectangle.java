package coordinateCalculator.domain;

public class Rectangle extends AbstractFigure {
    public static final int POINT_COUNT = 4;
    public static final String ERROR_INVALID_POINT_COUNT = "[ERROR] 사각형은 " + POINT_COUNT + "개의 점으로 이뤄져 있어야 합니다.";

    public Rectangle(Points points) {
        super(points);
        checkValidPoints(points);
    }

    @Override
    public double area() {
        return Math.abs(points().getDifferenceX() *  points().getDifferenceY());
    }

    @Override
    public void checkValidPoints(Points points) {
        if (points().isInvalidPoints(POINT_COUNT)) {
            throw new IllegalArgumentException(ERROR_INVALID_POINT_COUNT);
        }
    }
}
