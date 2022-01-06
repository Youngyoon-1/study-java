package blackJack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Deck {
    static final String ERROR_INVALID_COUNT = "[ERROR] 유효하지 않은 갯수 입니다.";
    private final Stack<Card> cards;

    public Deck(PickStrategy pickStrategy) {
        cards = pickStrategy.shuffle(createCards());
    }

    Stack<Card> createCards() {
        Stack<Card> cards = new Stack<>();
        Arrays.stream(Suit.values()).forEach(suit -> addCard(cards, suit));
        return cards;
    }

    private void addCard(Stack<Card> cards, Suit suit) {
        Arrays.stream(Denomination.values()).forEach(denomination -> cards.push(new Card(suit, denomination)));
    }

    public Cards getCard(int count) {
        checkCount(count);
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cards.add(this.cards.pop());
        }
        return new Cards(cards);
    }

    private void checkCount(int count) {
        if (count == 0 || count > this.cards.size()) {
            throw new IllegalArgumentException(ERROR_INVALID_COUNT);
        }
    }
}