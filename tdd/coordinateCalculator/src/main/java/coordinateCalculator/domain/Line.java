package coordinateCalculator.domain;

public class Line extends AbstractFigure {
    public static final int POINT_COUNT = 2;
    public static final String ERROR_INVALID_POINT_COUNT = "[ERROR] 선은 " + POINT_COUNT + "개의 점으로 이뤄져 있어야 합니다.";

    public Line(Points points) {
        super(points);
        checkValidPoints(points);
    }

    @Override
    public double area() {
        return points().calculateLine();
    }

    @Override
    public void checkValidPoints(Points points) {
        if (points.isInvalidPoints(POINT_COUNT)) {
            throw new IllegalArgumentException(ERROR_INVALID_POINT_COUNT);
        }
    }

    @Override
    public String getInfo() {
        return "두 점 사이의 거리는 " + area();
    }
}
