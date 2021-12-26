package coordinateCalculator.domain;

import java.util.Objects;

public class Point {
    public static final int COORDINATE_MINIMUM_NUMBER = 1;
    public static final int COORDINATE_MAXIMUM_NUMBER = 24;
    public static final String ERROR_INVALID_COORDINATE
        = "[ERROR] " + COORDINATE_MINIMUM_NUMBER + "부터 " + COORDINATE_MAXIMUM_NUMBER + "까지의 자연수만 허용됩니다.";
    private final int x;
    private final int y;

    public Point(int xCoordinate, int yCoordinate) {
        checkValidCoordinate(xCoordinate);
        checkValidCoordinate(yCoordinate);
        this.x = xCoordinate;
        this.y = yCoordinate;
    }

    public static Point of(int xCoordinate, int yCoordinate) {
        return new Point(xCoordinate, yCoordinate);
    }

    private static void checkValidCoordinate(int coordinate) {
        if (coordinate < COORDINATE_MINIMUM_NUMBER || coordinate > COORDINATE_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(ERROR_INVALID_COORDINATE);
        }
    }

    public double calculateDistance(Point other) {
        int xDifference = getXDifference(other);
        int yDifference = getYDifference(other);

        return Math.sqrt(xDifference * xDifference + yDifference * yDifference);
    }

    private int getYDifference(Point other) {
        return y - other.y;
    }

    private int getXDifference(Point other) {
        return x - other.x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point point = (Point)o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
