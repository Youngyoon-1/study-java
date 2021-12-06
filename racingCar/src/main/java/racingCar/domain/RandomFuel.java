package racingCar.domain;

import java.util.Random;

public class RandomFuel implements Fuel{
    private static final int FORWARD_THRESHOLD_NUMBER = 4;
    public static final int MAX_RANDOM_NUMBER = 9;

    @Override
    public boolean isLeft() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER) >= FORWARD_THRESHOLD_NUMBER;
    }
}
