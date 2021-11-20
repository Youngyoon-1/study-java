package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NoTest {
    @DisplayName("스트라이크 테스트")
    @Test
    void strikeTest(){
        assertThat(new No(0,1).compareTo(new No(0,1))).isEqualTo(Score.STRIKE);
    }
    @DisplayName("볼 테스트")
    @Test
    void ballTest(){
        assertThat(new No(0,1).compareTo(new No(1,1))).isEqualTo(Score.BALL);
    }
    @DisplayName("낫싱 테스트")
    @Test
    void nothingTest(){
        assertThat(new No(0,1).compareTo(new No(0,2))).isEqualTo(Score.NOTHING);
    }

}
