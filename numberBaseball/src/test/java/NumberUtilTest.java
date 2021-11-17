import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.NumberUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {

    @DisplayName("1~9까지의 중복값 없는 3자리 번호 생성")
    @ParameterizedTest
    @CsvSource(value={"000:123","123:246","876:987"},delimiter = ':')
    void makeNos(String input, String expected){
        int[] newInput = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        List<Integer> newExpected = Arrays.stream(expected.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        assertThat(NumberUtil.makeNos(newInput)).isEqualTo(newExpected);
    }
}
