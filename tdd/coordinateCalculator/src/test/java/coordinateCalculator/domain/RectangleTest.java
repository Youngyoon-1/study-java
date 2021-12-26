package coordinateCalculator.domain;

import static coordinateCalculator.domain.Rectangle.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @DisplayName("직사각형 넓이 구하기")
    @Test
    void area() {
        Points points
            = new Points(Arrays.asList(Point.of(10, 10), Point.of(22, 10), Point.of(22, 18), Point.of(10, 18)));
        assertThat(new Rectangle(points).area()).isEqualTo(96);
    }

    @DisplayName("점이 세 개일 경우 예외 발생")
    @Test
    void threePoints() {
        Points points
            = new Points(Arrays.asList(Point.of(10, 10), Point.of(22, 10), Point.of(22, 18)));
        assertThatThrownBy(() -> new Rectangle(points)).hasMessage(ERROR_INVALID_POINT_COUNT);
    }

    @DisplayName("점이 다섯 개일 경우 예외 발생")
    @Test
    void fivePoints() {
        Points points = new Points(Arrays.asList(
            Point.of(10, 10),
            Point.of(22, 10),
            Point.of(22, 18),
            Point.of(10, 18),
            Point.of(20, 20)
        ));
        assertThatThrownBy(() -> new Rectangle(points)).hasMessage(ERROR_INVALID_POINT_COUNT);
    }
}
