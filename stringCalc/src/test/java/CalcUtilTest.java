import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcUtilTest {
    String regex;

    @BeforeEach
    void setUp(){
        regex = "[\\+|\\*|/|-]";
    }

    @DisplayName("입력값중 숫자만 뽑아서 배열생성")
    @Test
    void removeOp(){
        assertThat(CalcUtil.removeOp(regex,"1+1")).isEqualTo(Arrays.asList(new String[]{"1","1"}));
        assertThat(CalcUtil.removeOp(regex,"11+111")).isEqualTo(Arrays.asList(new String[]{"11","111"}));
        assertThat(CalcUtil.removeOp(regex,"1+1-1/1*1")).isEqualTo(Arrays.asList(new String[]{"1","1","1","1","1"}));
    }
//
    @DisplayName("입력값중 연산자만 뽑아서 배열생성")
    @Test
    void removeNos(){
        assertThat(CalcUtil.removeNos("1+1")).isEqualTo(Arrays.asList(new String[]{"+"}));
        assertThat(CalcUtil.removeNos("1-1+1")).isEqualTo(Arrays.asList(new String[]{"-","+"}));
        assertThat(CalcUtil.removeNos("1+1-1/1*1")).isEqualTo(Arrays.asList(new String[]{"+","-","/","*"}));

    }

}
