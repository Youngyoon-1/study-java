package blackJack.domain;

public enum Symbol {
    SPADE("스페이드"),
    HEART("하트"),
    CLUB("클로버"),
    DIAMONDS("다이아몬드");

    private final String name;

    Symbol(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
