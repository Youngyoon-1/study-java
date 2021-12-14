package coordinateCalculator.domain;

public class CoordinateCalculator {
    private Coordinates coordinates;

    public void setCoordinates(String coordinates) {
        this.coordinates = new Coordinates(coordinates);
    }

    public double calcDistance() {
        return coordinates.getDistance();
    }
}
