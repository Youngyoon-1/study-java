package coordinateCalculator.domain;

public class Rectangle implements Figure{
    public static final String ERROR_INVALID_VALUE = "[ERROR] 네 개의 좌표값은 직사각형의 꼭지점이어야 합니다.";

    private final Points points;

    public Rectangle(String input) {
        points = check(new Points(input));
    }

    private Points check(Points points) {
        if (points.canMakeRectangle()) {
            return points;
        }
        throw new IllegalArgumentException(ERROR_INVALID_VALUE);
    }
}
