package coordinateCalculator.view;

import static coordinateCalculator.view.InputView.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import coordinateCalculator.domain.Point;
import coordinateCalculator.domain.Points;

public class InputViewTest {
    @DisplayName("입력값으로 점 생성하기")
    @Test
    void generatePoints() {
        assertThat(InputView.generatePoints("(10,10)-(14,15)"))
            .isEqualTo(new Points(Arrays.asList(Point.of(10, 10), Point.of(14, 15))));
    }

    @DisplayName("유효하지 입력값에 대한 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"(10,10)(14,15)", "10,10)-(14,15)", "(10,10)-(1415)", "(10,1014,15)"})
    void invalidInput(String input) {
        assertThatThrownBy(() -> InputView.checkValidation(input)).hasMessage(ERROR_INVALID_INPUT);
    }

    @DisplayName("유효한 입력값")
    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(14,15)", "(10,10)-(14,15)-(11,11)", "(10,10)-(22,10)-(22,18)-(10,18)"})
    void validInput(String input) {
        assertDoesNotThrow(() -> InputView.checkValidation(input));
    }
}
