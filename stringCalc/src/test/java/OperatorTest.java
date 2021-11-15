import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
//    Operator op;
//
//    @BeforeEach
//    void setUp(){
//        op = new Operator();
//    }

//    @DisplayName("Operator인스턴스 연산 테스트")
//    @Test
//    void opTest(){
//       Operator plus = new Operator("+",(a,b) -> a+b);
//       assertThat(plus.op.calc(1,2)).isEqualTo(3);
//        Operator minus = new Operator("+",(a,b) -> a-b);
//        assertThat(minus.op.calc(1,2)).isEqualTo(-1);
//        Operator multiply = new Operator("+",(a,b) -> a*b);
//        assertThat(multiply.op.calc(1,2)).isEqualTo(2);
//        Operator divide = new Operator("+",(a,b) -> a/b);
//        assertThat(divide.op.calc(1,2)).isEqualTo(0);
//    }
    @DisplayName("열거타입 연산기능수행 테스트")
    @ParameterizedTest
    @EnumSource(Operator.class)
    void calc(Operator operator){
        if(operator == Operator.PLUS)
            assertThat(operator.op.calc(1,2)).isEqualTo(3);
        if(operator == Operator.MINUS)
            assertThat(operator.op.calc(1,2)).isEqualTo(-1);
        if(operator == Operator.MULTIPLY)
            assertThat(operator.op.calc(1,2)).isEqualTo(2);
        if(operator == Operator.DIVIDE)
            assertThat(operator.op.calc(1,2)).isEqualTo(0);

        if(operator.symbol.equals("+"))
            assertThat(operator.op.calc(1,2)).isEqualTo(3);
        if(operator.symbol.equals("-"))
            assertThat(operator.op.calc(1,2)).isEqualTo(-1);
        if(operator.symbol.equals("*"))
            assertThat(operator.op.calc(1,2)).isEqualTo(2);
        if(operator.symbol.equals("/"))
            assertThat(operator.op.calc(1,2)).isEqualTo(0);
    }
}
