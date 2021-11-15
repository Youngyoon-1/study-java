import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidationUtilTest {

    @DisplayName("입력값 첫번째가 숫자일 경우")
    @Test
    void checkFirstIdx(){
        ValidationUtil.checkFirstIdx("1+1");
    }

    @DisplayName("입력값 첫번째가 숫자가 아닐 경우")
    @ParameterizedTest
    @ValueSource(strings = {"+11","-1","-","*9"})
    void checkFirstIdx(String s){
        assertThatIllegalArgumentException().isThrownBy(()->{
            ValidationUtil.checkFirstIdx(s);
        }).withMessageMatching("첫입력자는 숫자여야합니다.");
    }

    @DisplayName("입력값 마지막이 숫자일 경우")
    @Test
    void checkLastIdx(){
        ValidationUtil.checkLastIdx("1+1");
    }

    @DisplayName("입력값 마지막이 숫자가 아닐 경우")
    @ParameterizedTest
    @ValueSource(strings={"11+","1-","1-1-"})
    void checkLastIdx(String s){
        assertThatIllegalArgumentException().isThrownBy(()->{
            ValidationUtil.checkLastIdx(s);
        }).withMessageMatching("마지막 입력자는 숫자여야합니다.");
    }

    @DisplayName("입력값중 사칙연산자이외의 연산자가 없는 경우")
    @Test
    void checkOp(){
        ValidationUtil.checkOp("[\\+|\\*|/|-]","1+1");
    }

    @DisplayName("사칙연산자이외의 연산자가 있을 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1%1","2!2","2+3=5"})
    void checkOp(String s){
        assertThatIllegalArgumentException().isThrownBy(()->{
            ValidationUtil.checkOp("[\\+|\\*|/|-]",s);
        }).withMessageMatching("연산자가 올바르지 않습니다.");
    }
}
