package blackJack.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {
    @DisplayName("같은 카드 비교")
    @Test
    void sameCard() {
        Assertions.assertThat(Card.of(Suit.HEARTS, Denomination.ACE)).isEqualTo(Card.of(Suit.HEARTS, Denomination.ACE));
    }

    @DisplayName("서로 다른 카드 비교")
    @Test
    void otherCard() {
        assertThat(Card.of(Suit.CLUBS, Denomination.ACE)).isNotEqualTo(Card.of(Suit.HEARTS, Denomination.ACE));
    }
}
