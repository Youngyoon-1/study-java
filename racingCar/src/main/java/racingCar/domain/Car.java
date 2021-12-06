package racingCar.domain;

public class Car implements Comparable<Car>{
    private final Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        position = new Position();
    }

    public void move(Fuel fuel) {
        if(fuel.isLeft()) {
            position.move();
        }
    }

    public Position getPosition() {
        return position;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public Name getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.getPosition());
    }
}
