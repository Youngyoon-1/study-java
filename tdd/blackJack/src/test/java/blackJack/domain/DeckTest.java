package blackJack.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        PickStrategy noShuffle = cards -> cards;
        deck = new Deck(noShuffle);
    }

    @DisplayName("카드 생성")
    @Test
    void createCards() {
        Stack<Card> cards = deck.createCards();
        assertThat(new HashSet<>(cards).size()).isEqualTo(Denomination.values().length * Suit.values().length);
    }

    @DisplayName("카드 한장 뽑기")
    @Test
    void pickCard() {
        Stack<Card> cards = deck.createCards();
        while (!cards.isEmpty()) {
            assertThat(Collections.singletonList(cards.pop())).isEqualTo(deck.getCard(1));
        }
    }

    @DisplayName("카드 두장 뽑기")
    @Test
    void pickCards() {
        Card firstCard = new Card(Suit.CLUBS, Denomination.JACK);
        Card secondCard = new Card(Suit.CLUBS, Denomination.QUEEN);

        List<Card> expected = Arrays.asList(firstCard, secondCard);
        assertThat(deck.getCard(2)).isEqualTo(expected);
    }
}