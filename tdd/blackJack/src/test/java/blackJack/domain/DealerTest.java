package blackJack.domain;

import static org.assertj.core.api.Assertions.*;

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

    // @DisplayName("딜러 보유 카드 문자열로 반환")
    // @Test
    // void showCard() {
    //     Card card = Card.of(Suit.CLUBS, Denomination.ACE);
    //     player.initCards(new Cards(Collections.singletonList(card)));
    //     assertThat(player.showCard()).isEqualTo(Collections.singletonList(card.toString()));
    // }
}
