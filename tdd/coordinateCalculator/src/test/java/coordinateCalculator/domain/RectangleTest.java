package coordinateCalculator.domain;

import static coordinateCalculator.domain.Rectangle.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RectangleTest {
    @DisplayName("네 개의 좌표 연결 모양이 직사각형인 경우")
    @Test
    void validInput() {
        assertDoesNotThrow(() -> new Rectangle("(10,10)-(22,10)-(22,18)-(10,18)"));
    }

    @DisplayName("네 개의 좌표 연결 모양이 직사각형이 아닌 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"(11,10)-(22,10)-(22,18)-(10,18)", "(8,10)-(20,10)-(22,18)-(10,18)"})
    void invalidInput(String input) {
        assertThatThrownBy(() -> new Rectangle(input)).hasMessage(ERROR_INVALID_VALUE);
    }

    @DisplayName("사각형의 넓이 구하기")
    @Test
    void calculateArea() {
        assertThat(new Rectangle("(10,10)-(22,10)-(22,18)-(10,18)").calculate()).isEqualTo(96);
    }
}
