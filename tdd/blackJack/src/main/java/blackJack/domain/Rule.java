package blackJack.domain;

public enum Rule {
    PLAYING,
    BUST,
    BLACKJACK;

    public boolean isBlackJack() {
        return this == BLACKJACK;
    }

    public boolean isBust() {
        return this == BUST;
    }
}
