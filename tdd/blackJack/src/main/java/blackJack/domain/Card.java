package blackJack.domain;

import java.util.Objects;

public class Card {
    private final Denomination denomination;
    private final Suit suit;

    public Card(Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public static Card of(Suit suit, Denomination denomination) {
        return new Card(suit, denomination);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Card card = (Card)o;
        return denomination == card.denomination && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }
}

