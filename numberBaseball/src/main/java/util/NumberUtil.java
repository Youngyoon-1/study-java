package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NumberUtil {
    private static final List<Integer> NOS_REPO = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    private NumberUtil() throws InstantiationException {
        throw new InstantiationException("NumberUtil은 객체화 할 수 없습니다.");
    }

    public static List<Integer> makeNos(){
        //값을 끝에서부터 순차적으로 삭제하는것이 아니기 때문에 LinkedList를 사용했다.
        List<Integer> candidate = new LinkedList<Integer>();
        candidate.addAll(NOS_REPO);
        List<Integer> randomNos = new ArrayList<Integer>();
        while(randomNos.size() < 3){
            int idx = (int)(Math.random() * candidate.size());
            randomNos.add(candidate.remove(idx));
        }
        return randomNos;
    }

    //단위 테스트를 위해서 오버로딩했다.
    public static List<Integer> makeNos(int[] nos){
        List<Integer> candidate = new LinkedList<Integer>();
        List<Integer> makeNosByUser = new ArrayList<Integer>();
        candidate.addAll(NOS_REPO);
        for(int i = 0; makeNosByUser.size() < 3; i++){
            makeNosByUser.add(candidate.remove(nos[i]));
        }
        return makeNosByUser;
    }
}
