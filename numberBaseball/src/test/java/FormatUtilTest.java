import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.FormatUtil;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FormatUtilTest {
    @DisplayName("문자열 List<Integer>형으로 변환 테스트")
    @Test
    void convertStr(){
        assertThat(FormatUtil.convertStr("123")).isEqualTo(Arrays.asList(1,2,3));
        assertThat(FormatUtil.convertStr("14")).isEqualTo(Arrays.asList(1,4));
        assertThat(FormatUtil.convertStr("1")).isEqualTo(Arrays.asList(1));
    }
}
