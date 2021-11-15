import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcUtilTest {
    CalcUtil calcUtil;
    String regex;

    @BeforeEach
    void setUp(){
        calcUtil  =  new CalcUtil();
        regex = "[\\+|\\*|/|-]";
    }

    @DisplayName("입력값중 숫자만 뽑아서 배열생성")
    @Test
    void removeOp(){
        assertThat(calcUtil.removeOp(regex,"1+1")).isEqualTo(Arrays.asList(new String[]{"1","1"}));
        assertThat(calcUtil.removeOp(regex,"11+111")).isEqualTo(Arrays.asList(new String[]{"11","111"}));
        assertThat(calcUtil.removeOp(regex,"1+1-1/1*1")).isEqualTo(Arrays.asList(new String[]{"1","1","1","1","1"}));
    }
//
    @DisplayName("입력값중 연산자만 뽑아서 배열생성")
    @Test
    void removeNos(){
        assertThat(calcUtil.removeNos("1+1")).isEqualTo(Arrays.asList(new String[]{"+"}));
        assertThat(calcUtil.removeNos("1-1+1")).isEqualTo(Arrays.asList(new String[]{"-","+"}));
        assertThat(calcUtil.removeNos("1+1-1/1*1")).isEqualTo(Arrays.asList(new String[]{"+","-","/","*"}));

    }

}
