package coordinateCalculator.utils;

import static coordinateCalculator.utils.ValidationUtil.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationUtilTest {

    @DisplayName("입력값이 형식에 맞지않을 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"(1,2)+(1,2)", "(1,2 - 1,3)", "1 - 2", "(1,3),(1,5)"})
    void checkInvalidForm(String invalidInput) {
        assertThatThrownBy(() -> ValidationUtil.checkForm(invalidInput)).hasMessage(ERROR_PREFIX + ERROR_INVALID_FORM);
    }

    @DisplayName("입력값이 형식에 맞을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"(0,9)-(0,9)", "(1,6)-(4,5)"})
    void checkValidForm(String validInput) {
        assertDoesNotThrow(() -> ValidationUtil.checkForm(validInput));
    }

    @DisplayName("입력값 중 두 좌표가 중복일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"(0,9)-(0,9)", "(4,5)-(4,5)"})
    void checkDuplication(String input) {
        assertThatThrownBy(() -> ValidationUtil.checkDuplication(input)).hasMessage(ERROR_PREFIX + ERROR_DUPLICATION);
    }
}
