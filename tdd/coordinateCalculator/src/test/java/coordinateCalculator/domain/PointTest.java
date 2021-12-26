package coordinateCalculator.domain;

import static coordinateCalculator.domain.Point.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointTest {
    @DisplayName("점 생성시 지정 값 범위를 벗어날 경우 예외 발생 (1 ~ 24)")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "0:24", "1:25", "24:25", "0:25"}, delimiter = ':')
    void invalidPoint(int xCoordinate, int yCoordinate) {
        assertThatThrownBy(() -> Point.of(xCoordinate, yCoordinate)).hasMessage(ERROR_INVALID_COORDINATE);
    }

    @DisplayName("점 생성시 지정 값 범위를 벗어나지 않는 경우(1 ~ 24)")
    @Test
    void validPoint() {
        assertDoesNotThrow(() -> Point.of(1, 24));
    }

    @DisplayName("두 점 사이 거리 구하기")
    @Test
    void calculateDistance() {
        assertThat(Point.of(10, 10).calculateDistance(Point.of(14, 15))).isEqualTo(6.403124, offset(0.000001d));
    }

}
