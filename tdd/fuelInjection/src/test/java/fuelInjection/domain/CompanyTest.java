package fuelInjection.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyTest {
    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    void report(){
        Company com = Company.create();
        com.addCar(new Sonata(150));
        com.addCar(new K5(260));
        com.addCar(new Sonata(120));
        com.addCar(new Avante(300));
        com.addCar(new K5(390));

        assertThat(com.report()).isEqualTo(
            "Sonata : 15리터" + NEWLINE +
            "K5 : 20리터" + NEWLINE +
            "Sonata : 12리터" + NEWLINE +
            "Avante : 20리터" + NEWLINE +
            "K5 : 30리터" + NEWLINE
        );
    }
}
