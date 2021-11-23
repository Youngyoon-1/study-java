package racingCar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    public static final String POSITION_STRING = "-";
    public static final int ZERO = 0;

    private int position;

    public Position(){
        this.position = ZERO;
    }

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        position++;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        for(int idx = ZERO; idx < position; idx++){
            sb.append(POSITION_STRING);
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Position position) {
        //역전시킴
        return position.compareTo(this.position);
    }

    public int compareTo(int no) {
        if(this.position > no){
            return -1;
        }
        if(this.position < no){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
