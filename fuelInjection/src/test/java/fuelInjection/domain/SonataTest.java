package fuelInjection.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SonataTest {

    Sonata sonata;
    @BeforeEach
    void setUp(){
        sonata = new Sonata(100);
    }

    @DisplayName("연료량 구하기")
    @Test
    void getChargeQuantity(){
        assertThat(sonata.getChargeQuantity()).isEqualTo(10.0);
    }

    @DisplayName("필요한 연료량 문자열 반환 테스트")
    @Test
    void report(){
        assertThat(sonata.report()).isEqualTo("Sonata : 10리터");
    }

}
