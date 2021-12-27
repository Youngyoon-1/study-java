package coordinateCalculator.domain;

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
}
