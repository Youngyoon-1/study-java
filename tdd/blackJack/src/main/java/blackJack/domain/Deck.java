package blackJack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Deck {
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

    public List<Card> getCard(int count) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cards.add(this.cards.pop());
        }
        return cards;
    }
}