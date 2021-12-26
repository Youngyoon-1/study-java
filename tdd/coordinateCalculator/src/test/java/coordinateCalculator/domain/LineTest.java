package coordinateCalculator.domain;

import static coordinateCalculator.domain.Line.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LineTest {
    @DisplayName("선 생성시 유효성 검사, 선의 점 갯수가 하나일 경우")
    @Test
    void onePoint() {
        Points points = new Points(Collections.singletonList(Point.of(10, 10)));
        assertThatThrownBy(() -> new Line(points)).hasMessage(ERROR_INVALID_POINT_COUNT);
    }

    @DisplayName("선 생성시 유효성 검사, 선의 점 갯수가 세 개일 경우")
    @Test
    void threePoint() {
        Points points
            = new Points(Arrays.asList(Point.of(10, 10), Point.of(11, 11), Point.of(12, 12)));
        assertThatThrownBy(() -> new Line(points)).hasMessage(ERROR_INVALID_POINT_COUNT);
    }

    @DisplayName("선 길이 구하기")
    @Test
    void area() {
        Points points = new Points(Arrays.asList(Point.of(10, 10), Point.of(14, 15)));
        assertThat(new Line(points).area()).isEqualTo(6.403124, offset(0.000001d));
    }
}
