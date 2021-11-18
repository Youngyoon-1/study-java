import java.util.List;

public class ResultView {
    static void print(List<String> result){
        result.stream().forEach(score -> System.out.printf("%s ",score));
    }

    //오버로딩
    static void print(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
