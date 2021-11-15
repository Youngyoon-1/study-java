import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;

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

}
