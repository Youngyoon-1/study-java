package fuelInjection.domain;

public class Avante implements Car{
    private final String name = "Avante";
    private final double distancePerLiter = 15.0;
    private final double distance;

    public Avante(int distance) {
        this.distance = distance;
    }

    @Override
    public double getDistancePerLiter() {
        return distancePerLiter;
    }

    @Override
    public double getTripDistance() {
        return distance;
    }

    @Override
    public String getName() {
        return name;
    }
}
