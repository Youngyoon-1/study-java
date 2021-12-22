package coordinateCalculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointsTest {
    @DisplayName("네 개의 점이 직사각형을 이룰수 있는지 판별")
    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(22,10)-(22,18)-(10,18):true",
        "(11,10)-(22,10)-(22,18)-(10,18):false"}, delimiter = ':')
    void canMakeRectangle(String input, boolean expected) {
        assertThat(new Points(input).canMakeRectangle()).isEqualTo(expected);
    }
}
