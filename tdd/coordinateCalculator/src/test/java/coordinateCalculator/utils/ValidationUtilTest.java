package coordinateCalculator.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationUtilTest {
    private static final String ERROR_PREFIX = "[ERROR]";

    @DisplayName("입력값이 형식에 맞지않을 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"(1,2)+(1,2)", "(1,2 - 1,3)", "1 - 2", "(1,3),(1,5)"})
    void checkInvalidForm(String invalidInput) {
        assertThatThrownBy(() -> ValidationUtil.checkForm(invalidInput)).hasMessageContaining(ERROR_PREFIX);
    }

    @DisplayName("입력값이 형식에 맞을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"(0,9)-(0,9)", "(1,6)-(4,5)"})
    void checkValidForm(String validInput) {
        assertDoesNotThrow(() -> ValidationUtil.checkForm(validInput));
    }

    // @DisplayName("입력값이 형식에 맞지않을 경우 예외발생")
    // @Test
    // void checkDuplication() {
    //     assertThatThrownBy(() -> {
    //         ValidationUtil.checkDuplication((1, 2)-(1, 2));
    //     })
    // }
}
