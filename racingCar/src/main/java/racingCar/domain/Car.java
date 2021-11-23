package racingCar.domain;

public class Car {
    public static final int LIMITER = 4;
    public static final String SEPARATOR = " : ";
    public static final int LENGTH_LIMITER = 5;

    private final Position position;
    private final String name;

    public Car(String name) {
        checkLength(name);
        this.name = name;
        this.position = new Position();
    }

    public void move(int no) {
        if(canMove(no)){
            position.move();
        }
    }

    private void checkLength(String s){
        if(isOverLength(s)){
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private boolean isOverLength(String s){
        return s.length() > LENGTH_LIMITER;
    }

    private boolean canMove(int no){
        return no >= LIMITER;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + SEPARATOR);
        sb.append(position.report());
        return sb.toString();
    }

    public boolean isMaxPosition(Position position) {
        return this.position.equals(position);
    }

    public String getName() {
        return name;
    }

    public boolean positionOverThan(Position maxPosition) {
        return position.overThan(maxPosition);
    }

    public Position getPosition() {
        return position;
    }
}
