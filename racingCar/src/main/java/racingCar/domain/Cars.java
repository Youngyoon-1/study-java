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
        Position maxPosition = getMaxPosition();
        cars.stream().filter(car -> car.isMaxPosition(maxPosition)).forEach(car -> sb.append(car.getName() + SEPARATOR));
        sb.deleteCharAt(sb.length()- ONE);
        return sb.toString();
    }

    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    //스트림으로 리펙토링하기
    private Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for(Car car: cars){
            if(car.positionOverThan(maxPosition)){
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
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
