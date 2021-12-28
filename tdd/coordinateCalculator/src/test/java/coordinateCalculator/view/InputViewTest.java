package coordinateCalculator.view;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import coordinateCalculator.domain.Point;
import coordinateCalculator.domain.Points;

public class InputViewTest {
    @DisplayName("입력값으로 점 생성하기")
    @Test
    void generatePoints() {
        assertThat(InputView.generatePoints("(10,10)-(14,15)"))
            .isEqualTo(new Points(Arrays.asList(Point.of(10, 10), Point.of(14, 15))));
    }
}
