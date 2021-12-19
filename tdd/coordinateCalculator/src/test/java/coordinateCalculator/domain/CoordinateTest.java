package coordinateCalculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoordinateTest {
    @DisplayName("두개의 숫자로 첫번째는 x 두번째는 y 생성")
    @ParameterizedTest
    @CsvSource(value = {"(0,9):0:9", "(1,8):1:8"}, delimiter = ':')
    void createValueTest(String parameter, int xValue, int yValue) {
        Coordinate coordinate = new Coordinate(parameter);
        assertThat(coordinate.getX()).isEqualTo(xValue);
        assertThat(coordinate.getY()).isEqualTo(yValue);
    }
}
