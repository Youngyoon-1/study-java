package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final String SEPARATOR  = ",";
    public static final String LINE_BREAK = "\n";
    private final List<Car> cars;

    public Cars(String names){
        cars =  Arrays.stream(names.split(SEPARATOR)).map(Car::new).collect(Collectors.toList());
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        cars.stream().forEach(car -> sb.append(car.report() + LINE_BREAK));
        return sb.toString();
    }

//    public void play(int count){
//        for(int i = 0; i < count; i++){
//        }
//    }
}
