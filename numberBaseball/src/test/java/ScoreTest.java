import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    @DisplayName("BALL 계산 테스트 ")
    @ParameterizedTest
    @CsvSource(value={"123:123:0","123:316:2","456:765:2","456:789:0","123:345:1"},delimiter=':')
    void ball(String s1, String s2, int result){
        List<Integer> actual = Arrays.stream(s1.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        List<Integer> expected = Arrays.stream(s2.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        assertThat(Score.BALL.formula.calc(actual, expected)).isEqualTo(result);
    }
}
