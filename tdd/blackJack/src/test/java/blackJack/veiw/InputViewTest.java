package blackJack.veiw;

import blackJack.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static blackJack.veiw.InputView.ERROR_DUPLICATE;
import static blackJack.veiw.InputView.ERROR_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputViewTest {
    @DisplayName("입력값으로 플레이어 생성")
    @Test
    void createPlayer() {
        List<Player> actual = InputView.createPlayer("jadal,jayho");
        List<Player> expected = Arrays.asList(new Player("jadal"), new Player("jayho"));
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("이름 중복 체크")
    @Test
    void checkDuplication() {
        assertThatThrownBy(() -> InputView.checkDuplication("jadal,jadal")).hasMessage(ERROR_DUPLICATE);
        assertDoesNotThrow(() -> InputView.checkDuplication("jadal,jayho"));
    }

    @DisplayName("유효하지 않은 양식")
    @ParameterizedTest
    @ValueSource(strings = {"jadal", "jadal:jayho", "jadal.jayho", "jadal;jayho"})
    void invalidFormat(String s) {
        assertThatThrownBy(() -> InputView.checkFormat(s)).hasMessage(ERROR_FORMAT);
    }

    @DisplayName("유효한 양식")
    @Test
    void validFormat() {
        assertDoesNotThrow(() -> InputView.checkFormat("jadal,jayho"));
    }
}
