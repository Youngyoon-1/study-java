package baseball;

public class No {
    private final int index;
    private final int value;

    public No(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public Score compareTo(No no) {
        return no.matchWith(index, value);
    }

    private Score matchWith(int index, int value) {
        if(this.index == index && this.value == value){
            return Score.STRIKE;
        }
        if(this.value == value){
            return Score.BALL;
        }
        return Score.NOTHING;
    }
}
