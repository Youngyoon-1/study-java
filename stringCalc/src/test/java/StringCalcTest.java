import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalcTest {

    @BeforeEach
    void setUp(){
        StringCalc calc = StringCalc.getInstance();
    }

    @DisplayName("replacAll로 공백제거")
    @Test
    void replaceAll(){
        assertThat(" + 2  2  2+  23".replaceAll(" ","")).isEqualTo("+222+23");
    }


}
