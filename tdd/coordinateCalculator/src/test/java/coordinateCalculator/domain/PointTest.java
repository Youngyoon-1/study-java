package coordinateCalculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointTest {
    @DisplayName("두개의 숫자로 첫번째는 x 두번째는 y 생성")
    @ParameterizedTest
    @CsvSource(value = {"(1,9):1:9", "(4,5):4:5"}, delimiter = ':')
    void createValueTest(String parameter, int xValue, int yValue) {
        Point point = new Point(parameter);
        assertThat(point.getX()).isEqualTo(xValue);
        assertThat(point.getY()).isEqualTo(yValue);
    }
}
