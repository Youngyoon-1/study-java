import java.util.List;

public class ResultView {

    private ResultView() throws InstantiationException {
        throw new InstantiationException("ResultView는 객체화 할 수 없습니다.");
    }

    static void print(List<String> result){
        result.stream().forEach(score -> System.out.printf("%s ",score));
        System.out.println();
    }

    //오버로딩
    static void print(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
