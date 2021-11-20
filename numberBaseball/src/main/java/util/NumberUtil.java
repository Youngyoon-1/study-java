package util;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberUtil {

    public static final int LENGTH = 3;
    public static final int MAX_NO = 9;
    public static final int MIN_NO = 1;

    //set 자료구조를 사용해서 중복값 제외시킴
    //LinkedHashSet을 사용해서 입력된 순서대로 데이터를 관리할 수 있음 그래서 반복시 입력된 순서로 반복된다.
    //HashSet은 순서보장이 안됨.
    public static int makeNos(){
        Set<Integer> nos = new LinkedHashSet<Integer>();
        while(nos.size() < LENGTH){
            nos.add((int) (Math.random() * MAX_NO + MIN_NO));
        }
        return Integer.parseInt(nos.stream().map(Object::toString).reduce((a,b)->a+b).get());
    }
}
