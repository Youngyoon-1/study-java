package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp(){
        cars = new Cars("a,b,c");
    }

    @DisplayName("자동차 정보 문자열로 반환 테스트")
    @Test
    void report(){
        assertThat(cars.report()).isEqualTo("a : \nb : \nc : \n");
    }

    @DisplayName("우승자 자동차 이름 반환 테스트")
    @Test
    void getWinnerName(){
        assertThat(cars.getWinnerName()).isEqualTo("a,b,c");
    }

}
