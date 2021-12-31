package blackJack.domain;

public class Card {
    private Symbol symbol;
    private CardNumber number;

    public Card(Symbol symbol, CardNumber number) {
        this.symbol = symbol;
        this.number = number;
    }

    public static Card of(Symbol symbol, CardNumber number) {
        return new Card(symbol, number);
    }

    @Override
    public String toString() {
        return number.toString() + symbol;
    }

    public int getNumber() {
        return number.get();
    }

    public boolean isAce() {
        return number.isAce();
    }

    public boolean isTen() {
        return number.isTen();
    }
}
