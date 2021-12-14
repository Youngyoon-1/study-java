package coordinateCalculator.domain;

public class Coordinate {
    private Integer x;
    private Integer y;

    public Coordinate(String coordinate) {
        String[] coordinates = coordinate.replaceAll("[\\(\\)]", "").split(",");
        x = Integer.valueOf(coordinates[0]);
        y = Integer.valueOf(coordinates[1]);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public boolean isSame(int x, int y) {
        return this.x == x && this.y == y;
    }
}
