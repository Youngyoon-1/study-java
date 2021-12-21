package coordinateCalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static final String COORDINATE_DELIMITER = "-";
    public static final int FIRST_COORDINATE_INDEX = 0;
    public static final int SECOND_COORDINATE_INDEX = 1;

    private final Coordinate firstCoordinate;
    private final Coordinate secondCoordinate;

    public Line(String input) {
        String[] coordinates = input.split(COORDINATE_DELIMITER);
        firstCoordinate = new Coordinate(coordinates[FIRST_COORDINATE_INDEX]);
        secondCoordinate = new Coordinate(coordinates[SECOND_COORDINATE_INDEX]);
    }

    public double length() {
        int a = firstCoordinate.getX() - secondCoordinate.getX();
        int b = firstCoordinate.getY() - secondCoordinate.getY();
        return Math.sqrt(a * a + b * b);
    }

    public List<Coordinate> getCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(firstCoordinate);
        coordinates.add(secondCoordinate);
        return coordinates;
    }

}
