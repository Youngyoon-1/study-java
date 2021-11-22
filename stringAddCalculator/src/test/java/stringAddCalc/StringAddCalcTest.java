package stringAddCalc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalcTest {

    @DisplayName("빈 문자열, null일 경우 0을 반환")
    @Test
    void zeroOrNull(){
        assertThat(StringAddCalc.calc("")).isEqualTo(0);
        assertThat(StringAddCalc.calc(null)).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 입력 할 경우 해당 숫자 반환")
    @Test
    void onlyOne(){
        assertThat(StringAddCalc.calc("0")).isEqualTo(0);
        assertThat(StringAddCalc.calc("9")).isEqualTo(9);
        assertThat(StringAddCalc.calc("99")).isEqualTo(99);
    }

    @DisplayName("':',','을 split 후 더하기")
    @Test
    void specialChar(){
        assertThat(StringAddCalc.calc("1,2,3")).isEqualTo(6);

    }
}
