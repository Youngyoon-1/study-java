package blackJack.domain;

public enum Suit {
    SPADES("스페이드"),
    HEARTS("하트"),
    DIAMOND("다이아몬드"),
    CLUBS("클로버");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
