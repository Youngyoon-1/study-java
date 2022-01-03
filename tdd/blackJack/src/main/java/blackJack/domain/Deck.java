package blackJack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    public static final List<Card> deck = new ArrayList<>();
    private static final Random random = new Random();

    static {
        for (Symbol symbol : Symbol.values()) {
            createCards(symbol);
        }
    }

    private static void createCards(Symbol symbol) {
        for (CardNumber number : CardNumber.values()) {
            deck.add(Card.of(symbol, number));
        }
    }


    public static Cards getCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Card randomCard = deck.get(random.nextInt(deck.size()));
            cards.add(randomCard);
            deck.remove(randomCard);
        }
        return new Cards(cards);
    }

    public static Card getCard() {
        Card randomCard = deck.get(random.nextInt(deck.size()));
        deck.remove(randomCard);
        return randomCard;
    }
}
