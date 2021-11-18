import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    private List<Integer> converter(String s){
        return Arrays.stream(s.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    @DisplayName("BALL 계산 테스트 ")
    @ParameterizedTest
    @CsvSource(value={"123:123:0","123:316:2","456:765:2","456:789:0","123:345:1"},delimiter=':')
    void ball(String s1, String s2, int result){
        List<Integer> actual = converter(s1);
        List<Integer> expected = converter(s2);

        assertThat(Score.BALL.formula.calc(actual, expected)).isEqualTo(result);
    }

    @DisplayName("STRIKE 계산 테스트")
    @ParameterizedTest
    @CsvSource(value={"123:123:3","123:923:2","123:145:1","123:456:0"},delimiter = ':')
    void strike(String s1, String s2, int result){
        List<Integer> actual = converter(s1);
        List<Integer> expected = converter(s2);

        assertThat(Score.STRIKE.formula.calc(actual,expected)).isEqualTo(result);
    }

    @DisplayName("Nothing 계산 테스트")
    @ParameterizedTest
    @CsvSource(value={"123:456:1","123:123:0","123:345:0","567:765:0","456:789:1"},delimiter = ':')
    void nothing(String s1, String s2, int result){
        List<Integer> actual = converter(s1);
        List<Integer> expected = converter(s2);

        assertThat(Score.NOTHING.formula.calc(actual, expected)).isEqualTo(result);
    }

    @DisplayName("점수계산 테스트")
    @ParameterizedTest
    @CsvSource(value={"123:123:3스트라이크","123:132:2볼,1스트라이크","123:167:1스트라이크","123:256:1볼","123:456:낫싱","123:789:낫싱"},delimiter=':')
    void calcScore(String s1, String s2, String s3){
        List<Integer> actual = converter(s1);
        List<Integer> expected = converter(s2);
        List<String> result = Arrays.stream(s3.split(",")).collect(Collectors.toList());

        assertThat(Score.of(expected,actual)).isEqualTo(result);
    }
}
