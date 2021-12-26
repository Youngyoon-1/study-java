package coordinateCalculator.domain;

public abstract class AbstractFigure implements Figure{
    private Points points;

    AbstractFigure(Points points) {
        this.points = points;
    }

    @Override
    public Points points() {
        return points;
    }
}
