package coordinateCalculator.domain;

public class Triangle extends AbstractFigure {
    private static final int POINT_COUNT = 3;
    public static final String ERROR_INVALID_POINT_COUNT = "[ERROR] 삼각형의 점 갯수는 " + POINT_COUNT + "개 이어야 합니다.";
    public static final String ERROR_INVALID_TRIANGLE = "[ERROR] 삼각형이 아닙니다.";

    Triangle(Points points) {
        super(points);
        checkValidPoints(points);
        checkValidTriangle(points);
    }

    private void checkValidTriangle(Points points) {
        if (points.canNotMakeTriangle()) {
            throw new IllegalArgumentException(ERROR_INVALID_TRIANGLE);
        }
    }

    @Override
    public double area() {
        return points().calculateTriangle();
    }

    @Override
    public void checkValidPoints(Points points) {
        if (points().isInvalidPoints(POINT_COUNT)) {
            throw new IllegalArgumentException(ERROR_INVALID_POINT_COUNT);
        }
    }
}
