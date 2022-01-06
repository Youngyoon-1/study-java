package blackJack.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(new PlayerName("an"));
    }

    @DisplayName("이름 반환")
    @Test
    void playerToString() {
        assertThat(player.toString()).isEqualTo("an");
    }

    @DisplayName("플레이어 보유 카드 문자열로 반환")
    @Test
    void showCard() {
        Card card = Card.of(Suit.CLUBS, Denomination.ACE);
        player.initCards(new Cards(Collections.singletonList(card)));
        assertThat(player.showCard()).isEqualTo(Collections.singletonList(card.toString()));
    }
}
