package coordinateCalculator.domain;

import java.util.Arrays;

public class Coordinate {
    public static final int MAXIMUM_NUMBER = 24;

    private final Integer x;
    private final Integer y;

    public Coordinate(String coordinate) {
        String[] coordinates = coordinate.replaceAll("[()]", "").split(",");
        checkCoordinate(coordinates);
        x = Integer.valueOf(coordinates[0]);
        y = Integer.valueOf(coordinates[1]);
    }

    private void checkCoordinate(String[] coordinates) {
        Arrays.stream(coordinates).forEach(coordinate -> {
            if (Integer.parseInt(coordinate) > MAXIMUM_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 좌표값은 " + MAXIMUM_NUMBER + "을 넘을수 없습니다.");
            }
        });
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
