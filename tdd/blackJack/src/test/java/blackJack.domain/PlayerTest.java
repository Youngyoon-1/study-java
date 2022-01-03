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
}
