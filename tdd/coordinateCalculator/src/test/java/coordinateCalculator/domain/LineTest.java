package coordinateCalculator.domain;

import static coordinateCalculator.domain.Line.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LineTest {
    @DisplayName("선 생성시 유효성 검사, 2개의 점이 아닌 경우")
    @Test
    void invalidPoints() {
        Points points = new Points(Collections.singletonList(Point.of(10, 10)));
        assertThatThrownBy(() -> new Line(points)).hasMessage(ERROR_INVALID_POINT_COUNT);
    }

    @DisplayName("선 길이 구하기")
    @Test
    void area() {
        Points points = new Points(Arrays.asList(Point.of(10, 10), Point.of(14, 15)));
        assertThat(new Line(points).area()).isEqualTo(6.403124, offset(0.000001d));
    }
}
