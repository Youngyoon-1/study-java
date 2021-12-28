package coordinateCalculator.domain;

public interface Figure {
    double area();

    Points points();

    void checkValidPoints(Points points);

    String getInfo();

    boolean hasPoint(Point point);
}
