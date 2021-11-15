import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalcUtil {

    public List<String> removeOp(String regex, String s) {
        return Arrays.asList(s.split(regex));
    }

    public List<String> removeNos(String s) {
        return Arrays.stream(s.split("[0-9]"))
                .filter(op->!op.equals(""))
                .collect(Collectors.toList());
    }
}
