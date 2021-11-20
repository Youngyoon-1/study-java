package baseball;

import java.util.ArrayList;
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

    private Scores matchNos(List<No> nos) {
        return new Scores(this.nos.stream().map(no1 -> nos.stream().map(no2 -> no1.compareTo(no2)).collect(Collectors.toList()))
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
