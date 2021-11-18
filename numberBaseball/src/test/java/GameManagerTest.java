import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameManagerTest {
    GameManager gameManager;

    @BeforeEach
    void setUp(){
        gameManager = GameManager.getInstance();
    }

    @DisplayName("3스트라이크 체크 테스트")
    @ParameterizedTest
    @CsvSource(value={"3스트라이크:true","1스트라이크:false","1볼:false","낫싱:false"},delimiter=':')
    void check3Strike(String s, boolean bool){
        assertThat(gameManager.check3Strike(Arrays.asList(s))).isEqualTo(bool);
    }

    @DisplayName("값이 1이면 true 아니면 false 반환 테스트")
    @ParameterizedTest
    @CsvSource(value={"1:true","2:false"},delimiter=':')
    void checkNo(String s, boolean bool){
        assertThat(gameManager.checkNo(s)).isEqualTo(bool);
    }
}
