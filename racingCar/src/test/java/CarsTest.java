import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    Cars cars = new Cars("a,b,c");

    @DisplayName("자동차 정보 문자열로 반환 테스트")
    @Test
    void report(){
        assertThat(cars.report()).isEqualTo("a : -\nb : -\nc : -\n");
    }
}
