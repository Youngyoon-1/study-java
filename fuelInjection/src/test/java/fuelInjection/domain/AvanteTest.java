package fuelInjection.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AvanteTest {

    Avante avante;

    @BeforeEach
    void setUp(){
        avante = new Avante(150);
    }

    @DisplayName("연료량 구하기")
    @Test
    void getChargeQuantity(){
        assertThat(avante.getChargeQuantity()).isEqualTo(10.0);
    }

    @DisplayName("필요한 연료량 문자열 반환 테스트")
    @Test
    void report(){
        assertThat(avante.report()).isEqualTo("Avante : 10리터");
    }

}
