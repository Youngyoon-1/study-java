package racingCar.domain;

import java.util.Objects;

public class Position implements Comparable<Position>{
    public static final int MIN_POSITION = 0;

    private int position;

    public Position() {
        position = MIN_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        position++;
    }

    public int get() {
        return position;
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.position, position.get());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position1 = (Position)o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return Integer.toString(position);
    }
}
