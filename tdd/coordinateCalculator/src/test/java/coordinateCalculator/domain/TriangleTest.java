package coordinateCalculator.domain;

import static coordinateCalculator.domain.Triangle.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @DisplayName("삼각형 면적 구하기")
    @Test
    void area() {
        Points points = new Points(Arrays.asList(Point.of(10, 10), Point.of(14, 15), Point.of(20, 8)));
        assertThat(new Triangle(points).area()).isEqualTo(29.0, offset(0.1d));
    }

    @DisplayName("삼각형 점 갯수가 2개 일 경우 예외발생")
    @Test
    void twoPoints() {
        Points points = new Points(Arrays.asList(Point.of(10, 10), Point.of(14, 15)));
        assertThatThrownBy(() -> new Triangle(points)).hasMessage(ERROR_INVALID_POINT_COUNT);
    }

    @DisplayName("삼각형 점 갯수가 4개 일 경우 예외발생")
    @Test
    void fourPoints() {
        Points points = new Points(Arrays.asList(Point.of(10, 10), Point.of(14, 15), Point.of(20, 8), Point.of(18, 7)));
        assertThatThrownBy(() -> new Triangle(points)).hasMessage(ERROR_INVALID_POINT_COUNT);
    }

    @DisplayName("삼각형의 점들이 한 선에 있을 경우 예외 발생")
    @Test
    void pointsOnStraightLine() {
        Points points = new Points(Arrays.asList(Point.of(10, 10), Point.of(11, 11), Point.of(12, 12)));
        assertThatThrownBy(() -> new Triangle(points)).hasMessage(ERROR_INVALID_TRIANGLE);
    }
}
