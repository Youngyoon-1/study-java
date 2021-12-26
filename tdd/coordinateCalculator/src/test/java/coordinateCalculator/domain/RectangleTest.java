package coordinateCalculator.domain;

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
}
