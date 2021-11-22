import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp(){
        car = new Car("myCar");
    }

    @DisplayName("4이상일경우 전진 미만일경우 정지 테스트")
    @ParameterizedTest
    @CsvSource(value={"0:1","3:1","4:2","5:2"},delimiter = ':')
    void moveCar(int no, int position){
        car.move(no);
        assertThat(car.isPosition(position)).isTrue();
    }

    @DisplayName("자동차 정보 문자열 반환 테스트")
    @Test
    void report(){
        assertThat(car.report()).isEqualTo("myCar : -");
        car.move(4);
        assertThat(car.report()).isEqualTo("myCar : --");
        car.move(4);
        assertThat(car.report()).isEqualTo("myCar : ---");
    }

    @DisplayName("이름 5글자 초과시 예외발생 테스트")
    @Test
    void overLimitLength(){
        assertThatThrownBy(()-> new Car("123456")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> new Car("1234567")).isInstanceOf(IllegalArgumentException.class);
    }
}