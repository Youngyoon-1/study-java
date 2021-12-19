package fuelInjection.domain;

public class K5 implements Car{
    private final String name = "K5";
    private final double distancePerLiter = 13.0;
    private final double distance;

    public K5(int distance) {
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
