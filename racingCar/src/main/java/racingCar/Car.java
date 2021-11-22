package racingCar;

public class Car {
    public static final int ONE = 1;
    public static final int LIMITER = 4;
    public static final String POSITION_STRING = "-";
    public static final String SEPARATOR = " : ";
    public static final int LENGTH_LIMITER = 5;

    private int position = ONE;
    private final String name;

    public Car(String name) {
        checkLength(name);
        this.name = name;
    }

    public void move(int no) {
        if(canMove(no)){
            position++;
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
    
    public boolean isPosition(int i) {
        return i == position;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + SEPARATOR);
        for(int i = 0; i < position; i++){
            sb.append(POSITION_STRING);
        }
        return sb.toString();
    }
}
