package coordinateCalculator.domain;

public abstract class AbstractFigure implements Figure {
    private final Points points;

    AbstractFigure(Points points) {
        this.points = points;
    }

    @Override
    public Points points() {
        return points;
    }

    @Override
    public boolean hasPoint(Point point) {
        return points.hasPoint(point);
    }
}
