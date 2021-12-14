package coordinateCalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import coordinateCalculator.utils.ValidationUtil;

public class Coordinates {
    private List<Coordinate> coordinates;

    public Coordinates(String coordinates) {
        ValidationUtil.checkCoordinates(coordinates);
        this.coordinates = Arrays.stream(coordinates.split("-"))
            .map(coordinate -> new Coordinate(coordinate))
            .collect(Collectors.toList());
    }

    public List<Coordinate> get() {
        return coordinates;
    }

    public double getDistance() {
        Coordinate first = coordinates.get(0);
        Coordinate second = coordinates.get(1);
        int a = first.getX() - second.getX();
        int b = first.getY() - second.getY();
        return Math.sqrt((a * a) + (b * b));
    }
}
