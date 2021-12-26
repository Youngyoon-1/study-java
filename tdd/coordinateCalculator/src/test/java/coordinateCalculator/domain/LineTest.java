package coordinateCalculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @DisplayName("선 길이 구하기")
    @Test
    void area() {
        Points points = new Points(Arrays.asList(Point.of(10, 10), Point.of(14, 15)));
        assertThat(new Line(points).area()).isEqualTo(6.403124, offset(0.000001d));
    }
}
