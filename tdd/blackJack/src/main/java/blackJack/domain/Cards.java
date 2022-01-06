package blackJack.domain;

import java.util.List;

public class Cards {
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public Card get(int i) {
        return cards.get(i);
    }
}
