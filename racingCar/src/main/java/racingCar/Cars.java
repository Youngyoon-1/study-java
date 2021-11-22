package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final String SEPARATOR  = ",";
    private final List<Car> cars;

    public Cars(String names){
        cars =  Arrays.stream(names.split(SEPARATOR)).map(Car::new).collect(Collectors.toList());
    }
    
}
