package coordinateCalculator.domain;

public class Rectangle implements Figure{
    public static final String ERROR_INVALID_VALUE = "[ERROR] 네 개의 좌표값은 직사각형의 꼭지점이어야 합니다.";

    private final Line width;
    private final Line height;
    private final Points points;

    public Rectangle(String input) {
        points = check(new Points(input));
        width = calculateWidth(points);
        height = calculateHeight(points);
    }

    private Line calculateHeight(Points points) {
        return new Line(points.getHeightPoints());
    }

    private Line calculateWidth(Points points) {
        return new Line(points.getWidthPoints());
    }

    private Points check(Points points) {
        if (points.canMakeRectangle()) {
            return points;
        }
        throw new IllegalArgumentException(ERROR_INVALID_VALUE);
    }

    @Override
    public double calculate() {
        return width.length() * height.length();
    }
}
