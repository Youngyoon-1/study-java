package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class NosTest {

    @DisplayName("1스트라이크 테스트")
    @Test
    void strikeTest(){
        Nos actual = new Nos(Arrays.stream((new int[]{1,2,3})).boxed().collect(Collectors.toList()));
        Nos expected = new Nos(Arrays.stream(new int[]{1,4,5}).boxed().collect(Collectors.toList()));
        Scores result = actual.compareTo(expected);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(1);
        System.out.println(result.toString());
    }
    @DisplayName("1볼 테스트")
    @Test
    void ballTest(){
        Nos actual = new Nos(Arrays.stream((new int[]{1,2,3})).boxed().collect(Collectors.toList()));
        Nos expected = new Nos(Arrays.stream(new int[]{9,4,1}).boxed().collect(Collectors.toList()));
        Scores result = actual.compareTo(expected);
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(0);
        System.out.println(result.toString());
    }

    @DisplayName("낫싱 테스트")
    @Test
    void nothingTest(){
        Nos actual = new Nos(Arrays.stream((new int[]{1,2,3})).boxed().collect(Collectors.toList()));
        Nos expected = new Nos(Arrays.stream(new int[]{9,5,7}).boxed().collect(Collectors.toList()));
        Scores result = actual.compareTo(expected);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(0);
        System.out.println(result.toString());
    }

    @DisplayName("1스트라이크 1볼 테스트")
    @Test
    void combinationTest(){
        Nos actual = new Nos(Arrays.stream((new int[]{1,2,3})).boxed().collect(Collectors.toList()));
        Nos expected = new Nos(Arrays.stream(new int[]{9,2,1}).boxed().collect(Collectors.toList()));
        Scores result = actual.compareTo(expected);
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(1);
        System.out.println(result.toString());
    }

}
