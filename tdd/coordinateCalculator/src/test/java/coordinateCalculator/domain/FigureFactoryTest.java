package coordinateCalculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FigureFactoryTest {
    @DisplayName("좌표가 두 개인 경우 Line 객체 생성")
    @Test
    void createLine() {
        Figure figure = FigureFactory.from("(10,10)-(22,10)");
        assertThat(figure instanceof Line).isTrue();
    }

    @DisplayName("좌표가 네 개인 경우 Rectangle 객체 생성")
    @Test
    void createRectangle() {
        Figure figure = FigureFactory.from("(10,10)-(22,10)-(22,18)-(10,18)");
        assertThat(figure instanceof Rectangle).isTrue();
    }

    @DisplayName("좌표가 세 개인 경우 Triangle 객체 생성")
    @Test
    void createTriangle() {
        Figure figure = FigureFactory.from("(10,10)-(14,15)-(20,8)");
        assertThat(figure instanceof Triangle).isTrue();
    }
}
