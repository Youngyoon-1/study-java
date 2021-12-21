package coordinateCalculator.domain;

public class Point {
    public static final int X_INDEX = 0;
    public static final int Y_INDEX = 1;
    public static final String EMPTY_STRING = "";
    public static final String VALUE_DELIMITER = ",";

    private final Value x;
    private final Value y;

    public Point(String input) {
        String[] values = input.replaceAll("[()]", EMPTY_STRING).split(VALUE_DELIMITER);
        this.x = new Value(values[X_INDEX]);
        this.y = new Value(values[Y_INDEX]);
    }

    public int getX() {
        return x.getValue();
    }

    public int getY() {
        return y.getValue();
    }
}
