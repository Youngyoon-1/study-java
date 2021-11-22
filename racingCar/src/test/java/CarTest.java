import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    
    @DisplayName("4이상일경우 전진 미만일경우 정지 테스트")
    @ParameterizedTest
    @CsvSource(value={"0:0","3:0","4:1","5:1"},delimiter = ':')
    void moveCar(int no, int postion){
        Car car = new Car();
        car.move(no);
        assertThat(car.isPosition(postion)).isTrue();
    }

    @DisplayName("위치값 문자열 반환 테스트")
    @Test
    void report(){
        Car car = new Car();
        assertThat(car.report()).isEqualTo("");
        car.move(4);
        assertThat(car.report()).isEqualTo("-");
        car.move(4);
        assertThat(car.report()).isEqualTo("--");
    }
}
