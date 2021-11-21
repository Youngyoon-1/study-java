package baseball;

import java.util.List;

public class Scores {
    public static final int LENGTH = 3;
    private final List<Score> scores;

    public Scores(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if(scores.contains(Score.STRIKE)){
            sb.append(getStrikeCount() + "스트라이크 ");
        }
        if(scores.contains(Score.BALL)){
            sb.append(getBallCount() + "볼 ");
        }
        if(!scores.contains(Score.STRIKE) && !scores.contains(Score.BALL)){
            sb.append("낫싱");
        }

        return sb.toString();
    }

    public int getBallCount() {
        return (int) scores.stream().filter(score -> score.isBall()).count();
    }

    public int getStrikeCount() {
        return (int) scores.stream().filter(score -> score.isStrike()).count();
    }

    public boolean is3Strike(){
        return getStrikeCount() == LENGTH;
    }
}
