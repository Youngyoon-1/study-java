package baseball;

public enum Score {
    STRIKE,
    BALL,
    NOTHING;

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }
}
