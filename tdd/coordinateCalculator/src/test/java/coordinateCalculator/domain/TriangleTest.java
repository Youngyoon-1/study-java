package coordinateCalculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @DisplayName("삼각형 넓이 구하기")
    @Test
    void calculate() {
        assertThat(new Triangle("(1,1)-(2,10)-(7,5)").calculate()).isEqualTo(25.0, offset(0.1d));
    }
}
