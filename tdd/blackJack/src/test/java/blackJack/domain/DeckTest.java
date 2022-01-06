package blackJack.domain;

import static blackJack.domain.Deck.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
            Cards actual = new Cards(Collections.singletonList(cards.pop()));
            assertThat(actual).isEqualTo(deck.getCard(1));
        }
    }

    @DisplayName("카드 두장 뽑기")
    @Test
    void pickCards() {
        Card firstCard = new Card(Suit.CLUBS, Denomination.JACK);
        Card secondCard = new Card(Suit.CLUBS, Denomination.QUEEN);

        List<Card> expected = Arrays.asList(firstCard, secondCard);
        assertThat(deck.getCard(2)).isEqualTo(new Cards(expected));
    }

    @DisplayName("뽑을 카드 갯수가 유효하지 않을 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 53})
    void invalidCount(int count) {
        assertThatThrownBy(() -> deck.getCard(count)).hasMessage(ERROR_INVALID_COUNT);
    }
}