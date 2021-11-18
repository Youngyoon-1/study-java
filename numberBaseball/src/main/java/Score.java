import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public enum Score {
    BALL((a,b) -> ((int) a.stream()
                .filter(no -> b.stream().anyMatch(Predicate.isEqual(no)))
                .count() - (int)IntStream.range(0, a.size()).filter(i -> a.get(i)==b.get(i)).count())),
    STRIKE((a,b) -> (int)IntStream.range(0,a.size()).filter(i -> a.get(i)==b.get(i)).count());

    Formula formula;

    Score(Formula formula){
        this.formula = formula;
    }

    @FunctionalInterface
    interface Formula{
        int calc(List<Integer> actual, List<Integer> expected);
    }
}
