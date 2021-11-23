package fuelInjection.domain;


public class Sonata implements Car{

    private final String name = "Sonata";
    private final double distancePerLiter = 10.0;
    private final double distance;

    public Sonata(int distance) {
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
