package stringAddCalc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalcTest {

    @DisplayName("빈 문자열, null일 경우 0을 반환")
    @Test
    void split(){
        assertThat(StringAddCalc.calc("")).isEqualTo(0);
        assertThat(StringAddCalc.calc(null)).isEqualTo(0);
    }

}
