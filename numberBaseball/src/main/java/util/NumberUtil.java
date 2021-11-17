package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NumberUtil {
    private static final List<Integer> nosRepo = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    public static List<Integer> makeNos(){
        //삭제시 ArrayList보다 효율적이므로 LinkedList사용
        LinkedList<Integer> candidate = new LinkedList<Integer>();
        candidate.addAll(nosRepo);
        List<Integer> randomNos = new ArrayList<Integer>();
        while(randomNos.size() < 3){
            int idx = (int)(Math.random() * candidate.size());
            randomNos.add(candidate.remove(idx));
        }
        return randomNos;
    }

    //단위 테스트를 위해서 오버로딩했음
    public static List<Integer> makeNos(int[] nos){
        LinkedList<Integer> candidate = new LinkedList<Integer>();
        List<Integer> makeNosByUser = new ArrayList<Integer>();
        candidate.addAll(nosRepo);
        for(int i = 0; makeNosByUser.size() < 3; i++){
            makeNosByUser.add(candidate.remove(nos[i]));
        }
        return makeNosByUser;
    }
}
