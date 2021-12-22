package coordinateCalculator.dto;

public class Result <T> {
    private final String prefix;
    private final T result;

    public Result(String prefix, T result) {
        this.prefix = prefix;
        this.result = result;
    }

    @Override
    public String toString() {
        return prefix + result;
    }
}
