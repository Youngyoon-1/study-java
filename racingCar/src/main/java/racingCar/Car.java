package racingCar;

public class Car {
    public static final int ZERO = 0;
    public static final int LIMITER = 4;

    private int position = ZERO;
    
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
}
