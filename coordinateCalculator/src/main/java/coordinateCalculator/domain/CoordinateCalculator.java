package coordinateCalculator.domain;

import coordinateCalculator.view.View;

public class CoordinateCalculator {
    private Coordinates coordinates;

    public void setCoordinates(String coordinates) {
        this.coordinates = new Coordinates(coordinates);
    }

    public void calcDistance() {
        View.printCoordinates(coordinates);
        View.printResult(coordinates.getDistance());
    }
}
