package baseball;

public class Token {
    public static final int ONE = 1;
    public static final int TWO = 2;

    private final int no;

    public Token(int no){
        checkValid(no);
        this.no = no;
    }

    private void checkValid(int no) {
        checkLength(no);
        checkArgument(no);
    }

    private void checkArgument(int no) {
        if(no != ONE && no != TWO){
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    private void checkLength(int no) {
        if(Integer.toString(no).length() != ONE){
            throw new IllegalArgumentException("한자리 숫자만 입력해주세요.");
        }
    }

    public Switch read(){
        if(no == ONE){
            return Switch.RESTART;
        }
        return Switch.END;
    }

}
