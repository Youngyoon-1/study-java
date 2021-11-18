import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum Score {
    //함수적 인터페이스 Predicate의 정적메서드인 isEqual을 사용해봤다.
    BALL("볼",(a,b) -> (int) a.stream().filter(no -> b.stream().anyMatch(Predicate.isEqual(no))).count()
            - (int)IntStream.range(0, a.size()).filter(i -> a.get(i)==b.get(i)).count()),

    STRIKE("스트라이크",(a,b) -> (int)IntStream.range(0,a.size()).filter(i -> a.get(i)==b.get(i)).count()),

    NOTHING("낫싱",(a,b) -> {
        if((int)a.stream().filter(no -> b.stream().anyMatch(Predicate.isEqual(no))).count() == 0){
            return 1;
        }
        return 0;
    });

    String name;
    Formula formula;

    Score(String name, Formula formula){
        this.name = name;
        this.formula = formula;
    }

    public static List<String> of(List<Integer> actual, List<Integer> expected){
        return Arrays.stream(Score.values())
                .filter(score -> score.formula.calc(actual,expected) != 0)
                .map(score -> {
                    if(score.name.equals("낫싱")){
                        return "낫싱";
                    }
                    return score.formula.calc(actual,expected) + score.name;
                })
                .collect(Collectors.toList());
    }

    @FunctionalInterface
    interface Formula{
        int calc(List<Integer> actual, List<Integer> expected);
    }
}
