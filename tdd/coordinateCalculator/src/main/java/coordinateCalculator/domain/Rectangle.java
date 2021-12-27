package coordinateCalculator.domain;

public class Rectangle extends AbstractFigure {
    public static final int POINT_COUNT = 4;
    public static final String ERROR_INVALID_POINT_COUNT = "[ERROR] 사각형은 " + POINT_COUNT + "개의 점으로 이뤄져 있어야 합니다.";
    public static final String ERROR_INVALID_RECTANGLE = "[ERROR] 직사각형이 아닙니다.";

    public Rectangle(Points points) {
        super(points);
        checkValidPoints(points);
        checkValidRectangle(points);
    }

    private void checkValidRectangle(Points points) {
        if (!points.canMakeRectangle()) {
            throw new IllegalArgumentException(ERROR_INVALID_RECTANGLE);
        }
    }

    @Override
    public double area() {
        return points().calculateRectangle();
    }

    @Override
    public void checkValidPoints(Points points) {
        if (points().isInvalidPoints(POINT_COUNT)) {
            throw new IllegalArgumentException(ERROR_INVALID_POINT_COUNT);
        }
    }
}
