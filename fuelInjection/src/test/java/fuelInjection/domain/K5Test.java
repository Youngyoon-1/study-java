package fuelInjection.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class K5Test {

    K5 k5;

    @BeforeEach
    void setUp(){ k5 = new K5(130); }

    @DisplayName("연료량 구하기")
    @Test
    void getChargeQuantity(){
        assertThat(k5.getChargeQuantity()).isEqualTo(10.0);
    }

    @DisplayName("필요한 연료량 문자열 반환 테스트")
    @Test
    void report(){
        assertThat(k5.report()).isEqualTo("K5 : 10리터");
    }

}
