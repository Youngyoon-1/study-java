package blackJack.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerTest {
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
    }

    @DisplayName("이름 반환")
    @Test
    void playerToString() {
        assertThat(dealer.toString()).isEqualTo("딜러");
    }

    @DisplayName("딜러 보유 카드 문자열 리스트로 반환")
    @Test
    void showCard() {
        Card firstCard = Card.of(Suit.CLUBS, Denomination.ACE);
        Card secondCard = Card.of(Suit.CLUBS, Denomination.TWO);
        dealer.initCards(new Cards(Arrays.asList(firstCard, secondCard)));
        assertThat(dealer.showCard()).isEqualTo(Collections.singletonList(firstCard.toString()));
    }
}
