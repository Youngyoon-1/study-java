package racingCar;

public class Car {
    public static final int ZERO = 0;
    public static final int LIMITER = 4;
    public static final String POSITION_STRING = "-";

    private int position = ZERO;

    public Car(String s) {
        if(s.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void move(int no) {
        if(canMove(no)){
            position++;
        }
    }

    private boolean canMove(int no){
        return no >= LIMITER;
    }
    
    public boolean isPosition(int i) {
        return i == position;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < position; i++){
            sb.append(POSITION_STRING);
        }
        return sb.toString();
    }
}
