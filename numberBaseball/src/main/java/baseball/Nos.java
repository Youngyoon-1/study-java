package baseball;

import util.FormatUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Nos {
    private static final int ZERO = 0;
    public static final int LENGTH = 3;

    private final List<No> nos;

    public Nos(int no) {
        checkValid(no);
        List<Integer> list = FormatUtil.convertList(no);
        this.nos = IntStream.range(ZERO, LENGTH).mapToObj(i -> new No(i,list.get(i))).collect(Collectors.toList());
    }

    public Scores compareTo(Nos expected) {
        return expected.matchNos(nos);
    }

    private List<Score> compareTo(No inputNo){
        return nos.stream().map(no -> no.compareTo(inputNo)).collect(Collectors.toList());
    }

    private Scores matchNos(List<No> nos) {
        return new Scores(nos.stream().map(no-> compareTo(no))
                    .map(li -> {
                        if(li.contains(Score.STRIKE)){
                            return Score.STRIKE;
                        }
                        if(li.contains(Score.BALL)){
                            return Score.BALL;
                        }
                        return Score.NOTHING;
                    }).collect(Collectors.toList()));
    }

    private void checkValid(int no){
        checkLength(no);
        checkDuplicate(no);
        checkIsZero(no);
    }

    private void checkIsZero(int no) {
        if(Integer.toString(no).contains("0")){
            throw new IllegalArgumentException("0을 제외한 1 부터 9까지의 숫자를 입력하세요.");
        }
    }

    private void checkDuplicate(int no) {
        if(Arrays.stream(Integer.toString(no).split("")).distinct().count() != LENGTH){
            throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다. 중복없이 입력하세요.");
        }

    }

    private void checkLength(int no) {
        if(Integer.toString(no).length() != LENGTH){
            throw new IllegalArgumentException("숫자 세자리를 입력해주세요.");
        }
    }

}
