package coordinateCalculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @DisplayName("두 좌표 사이 거리 계산")
    @Test
    void getLength() {
        Line line = new Line("(10,10)-(14,15)");
        assertThat(line.length()).isEqualTo(6.403124, offset(0.000001d));
    }
}
