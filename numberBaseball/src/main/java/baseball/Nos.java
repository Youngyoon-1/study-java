package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Nos {
    private static final int ZERO = 0;
    public static final int LENGTH = 3;

    private final List<No> nos;

    public Nos(List<Integer> no) {
        this.nos = IntStream.range(ZERO, LENGTH).mapToObj(i -> new No(i,no.get(i))).collect(Collectors.toList());
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
}
