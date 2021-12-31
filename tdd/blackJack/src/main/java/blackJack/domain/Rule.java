package blackJack.domain;

public enum Rule {
    PLAYING(0),
    BUST(22),
    BLACKJACK(21);

    private final int number;

    Rule(int number) {
        this.number = number;
    }

    public boolean isBlackJack() {
        return this == BLACKJACK;
    }

    public int number() {
        return number;
    }
}
