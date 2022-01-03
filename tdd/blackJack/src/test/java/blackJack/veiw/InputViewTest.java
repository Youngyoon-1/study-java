package blackJack.veiw;

import blackJack.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @DisplayName("입력값으로 플레이어 생성")
    @Test
    void createPlayer() {
        List<Player> actual = InputView.createPlayer("jadal,jayho");
        List<Player> expected = Arrays.asList(new Player("jadal"), new Player("jayho"));
        assertThat(actual).isEqualTo(expected);
    }
}
