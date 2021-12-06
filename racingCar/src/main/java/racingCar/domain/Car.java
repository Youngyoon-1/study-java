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

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.getPosition());
    }

    public Car deepClone() {
        Car newCar = new Car(new Name(name.toString()));
        newCar.setPosition(new Position(position.get()));
        return newCar;
    }
}
