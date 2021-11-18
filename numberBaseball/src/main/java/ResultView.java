import java.util.List;

public class ResultView {
    static void print(List<String> result){
        result.stream().forEach(score -> System.out.printf("%s ",score));
    }
}
