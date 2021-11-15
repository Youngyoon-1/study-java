import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalcTest {

    StringCalc calc;

    @BeforeEach
    void setUp(){ calc = StringCalc.getInstance(); }

    @DisplayName("replacAll로 공백제거")
    @Test
    void replaceAll(){
        assertThat(" + 2  2  2+  23".replaceAll(" ","")).isEqualTo("+222+23");
    }

    @DisplayName("싱글톤패턴 테스트")
    @Test
    void isSingleton(){
        assertThat(calc).isEqualTo(StringCalc.getInstance());
    }

    @DisplayName("계산기능 테스트")
    @ParameterizedTest
    @CsvSource(value={"0+0:0","1+2-3/2*2:0","100+100-100*5/2:250","10-10+1000/2*5:2500"},delimiter=':')
    void calc(String s, int expected){
        assertThat(calc.calc(s)).isEqualTo(expected);
    }
}
