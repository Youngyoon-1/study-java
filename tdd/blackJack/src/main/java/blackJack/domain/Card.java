package blackJack.domain;

public class Card {
    private Symbol symbol;
    private CardNumber number;

    @Override
    public String toString() {
        return number.toString() + symbol;
    }

    public int getNumber() {
        return number.get();
    }
}
