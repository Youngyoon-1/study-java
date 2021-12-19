package coordinateCalculator.domain;

import static coordinateCalculator.domain.Value.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValueTest {
    @DisplayName("생성자의 매개변수 값이 최대허용 값을 넘었을 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"25", "99"})
    void invalidParameter(String parameter) {
        assertThatThrownBy(() -> new Value(parameter)).hasMessage(ERROR_INVALID_VALUE);
    }

    @DisplayName("생성자의 매개변수 값이 최대허용 값을 넘지 않을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0", "24"})
    void validParameter(String parameter) {
        assertDoesNotThrow(() -> new Value(parameter));
    }
}
