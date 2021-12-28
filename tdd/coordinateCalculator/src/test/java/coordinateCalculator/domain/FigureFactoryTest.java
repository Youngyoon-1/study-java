package coordinateCalculator.domain;

import static coordinateCalculator.domain.FigureFactory.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FigureFactoryTest {
    @DisplayName("선 생성하기")
    @Test
    void generateLine() {
        Points points = new Points(Arrays.asList(Point.of(10, 10), Point.of(11, 11)));
        assertThat(FigureFactory.create(points) instanceof Line).isTrue();
    }

    @DisplayName("사각형 생성하기")
    @Test
    void generateRectangle() {
        Points points = new Points(Arrays.asList(
            Point.of(10, 10),
            Point.of(22, 10),
            Point.of(22, 18),
            Point.of(10, 18)
        ));
        assertThat(FigureFactory.create(points) instanceof Rectangle).isTrue();
    }

    @DisplayName("삼각형 생성하기")
    @Test
    void generateTriangle() {
        Points points = new Points(Arrays.asList(
            Point.of(10, 10),
            Point.of(14, 15),
            Point.of(20, 8)
        ));
        assertThat(FigureFactory.create(points) instanceof Triangle).isTrue();
    }

    @DisplayName("점 갯수가 유효하지 않을 경우 예외 발생")
    @Test
    void invalidPoints() {
        Points points = new Points(Collections.singletonList(Point.of(10, 10)));
        assertThatThrownBy(() -> FigureFactory.create(points)).hasMessage(ERROR_INVALID_POINTS);
    }
}
