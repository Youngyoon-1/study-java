package racingCar.domain;

import racingCar.utils.NumberUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final String SEPARATOR  = ",";
    public static final String LINE_BREAK = "\n";
    public static final int ONE = 1;
    public static final int ZERO = 0;

    private final List<Car> cars;

    public Cars(String names){
        cars =  Arrays.stream(names.split(SEPARATOR)).map(Car::new).collect(Collectors.toList());
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        cars.stream().forEach(car -> sb.append(car.report() + LINE_BREAK));
        return sb.toString();
    }

    public String getWinnerName(){
        StringBuilder sb = new StringBuilder();
        cars.stream().filter(car -> car.isMaxPosition(getMaxPosition())).forEach(car -> sb.append(car.getName() + SEPARATOR));
        sb.deleteCharAt(sb.length()- ONE);
        return sb.toString();
    }

    private Position getMaxPosition() {
        return cars.stream().map(Car::getPosition).max(Position::compareTo).get();
    }

    public String play(int count){
        StringBuilder sb = new StringBuilder();
        for(int i = ZERO; i < count; i++){
            cars.stream().forEach(car -> car.move(NumberUtil.makeNo()));
            sb.append(report() + LINE_BREAK);
        }
        return sb.toString();
    }
}
