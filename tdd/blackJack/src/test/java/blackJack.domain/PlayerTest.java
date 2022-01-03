package blackJack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @DisplayName("이름 반환")
    @Test
    void playerToString() {
        Player player = new Player(new PlayerName("an"));
        assertThat(player.toString()).isEqualTo("an");
    }

//    @DisplayName("배팅금액 설정")
//    @Test
//    void createBettingAmount() {
//        Player an = new Player(new PlayerName("an"));
//        an.setBettingAmount(new BettingAmount(1000));
//
//        assertThat(an.)
//    }
}
