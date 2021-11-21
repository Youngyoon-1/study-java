package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NosTest {

    @DisplayName("1스트라이크 테스트")
    @Test
    void strikeTest(){
        Nos actual = new Nos(123);
        Nos expected =  new Nos(156);
        Scores result = actual.compareTo(expected);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(1);
        System.out.println(result.toString());
    }

    @DisplayName("1볼 테스트")
    @Test
    void ballTest(){
        Nos actual = new Nos(123);
        Nos expected = new Nos(356);
        Scores result = actual.compareTo(expected);
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(0);
        System.out.println(result.toString());
    }

    @DisplayName("낫싱 테스트")
    @Test
    void nothingTest(){
        Nos actual = new Nos(123);
        Nos expected = new Nos(456);
        Scores result = actual.compareTo(expected);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(0);
        System.out.println(result.toString());
    }

    @DisplayName("1스트라이크 1볼 테스트")
    @Test
    void combinationTest(){
        Nos actual = new Nos(123);
        Nos expected = new Nos(137);
        Scores result = actual.compareTo(expected);
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(1);
        System.out.println(result.toString());
    }

}
