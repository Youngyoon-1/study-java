package blackJack.domain;

import static blackJack.domain.BettingAmount.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import blackJack.domain.BettingAmount;

public class BettingAmountTest {
    @DisplayName("배팅금액이 10의 배수가 아닐 경우 예외발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 9, 10001})
    void invalidAmount(int i) {
        assertThatThrownBy(() -> new BettingAmount(i)).hasMessage(ERROR_INVALID_AMOUNT);
    }
}
