package racingCar.domain;

public class Car {
    public static final int LIMITER = 4;
    public static final String SEPARATOR = " : ";

    private final Position position;
    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(int no) {
        if(canMove(no)){
            position.move();
        }
    }

    private boolean canMove(int no){
        return no >= LIMITER;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(name.report() + SEPARATOR);
        sb.append(position.report());
        return sb.toString();
    }

    public boolean isMaxPosition(Position position) {
        return this.position.equals(position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
