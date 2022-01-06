package blackJack.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

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

    @DisplayName("플레이어 보유 카드 문자열 리스트로 반환")
    @Test
    void showCard() {
        Card firstCard = Card.of(Suit.CLUBS, Denomination.ACE);
        Card secondCard = Card.of(Suit.CLUBS, Denomination.TWO);
        player.initCards(new Cards(Arrays.asList(firstCard, secondCard)));
        assertThat(player.showCard()).isEqualTo(Arrays.asList(firstCard.toString(), secondCard.toString()));
    }
}
