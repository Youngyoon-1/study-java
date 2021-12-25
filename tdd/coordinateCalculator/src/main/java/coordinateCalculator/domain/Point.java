package coordinateCalculator.domain;

public class Point {
    public static final int COORDINATE_MINIMUM_NUMBER = 1;
    public static final int COORDINATE_MAXIMUM_NUMBER = 24;
    public static final String ERROR_INVALID_COORDINATE
        = "[ERROR] " + COORDINATE_MINIMUM_NUMBER + "부터 " + COORDINATE_MAXIMUM_NUMBER + "까지의 자연수만 허용됩니다.";

    private final int x;
    private final int y;

    public Point(int xCoordinate, int yCoordinate) {
        this.x = xCoordinate;
        this.y = yCoordinate;
    }

    public static Point of(int xCoordinate, int yCoordinate) {
        checkValidCoordinate(xCoordinate);
        checkValidCoordinate(yCoordinate);
        return new Point(xCoordinate, yCoordinate);
    }

    private static void checkValidCoordinate(int coordinate) {
        if (coordinate < COORDINATE_MINIMUM_NUMBER || coordinate > COORDINATE_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(ERROR_INVALID_COORDINATE);
        }
    }
}
