package stringAddCalc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalcTest {

    @DisplayName("빈 문자열, null일 경우 0을 반환")
    @Test
    void zeroOrNull(){
        assertThat(StringAddCalc.calc("")).isEqualTo(0);
        assertThat(StringAddCalc.calc(null)).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 입력 할 경우 해당 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings={"0","9","99"})
    void onlyOne(String s){
        assertThat(StringAddCalc.calc(s)).isEqualTo(Integer.parseInt(s));
    }

    @DisplayName("':',','을 split 후 더하기")
    @ParameterizedTest
    @CsvSource(value={"1,2,3;6","1:2:3;6","1:2,3;6","1,2:3;6"},delimiter = ';')
    void specialChar(String s, int expected){
        assertThat(StringAddCalc.calc(s)).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자 //구분자\n 사이의 구분자로 split 후 더하기")
    @ParameterizedTest
    @ValueSource(strings={"//;\n1;2;3","///\n1/2/3","//&\n1&2&3"})
    void customDelimiter(String s){
        assertThat(StringAddCalc.calc(s)).isEqualTo(6);
    }

    @DisplayName("음수값이 들어간 경우 RuntimeExceptin 발생")
    @Test
    void throwRuntimeException(){
        assertThatThrownBy(()->StringAddCalc.calc("-1,2,3")).isInstanceOf(RuntimeException.class);
    }
}
