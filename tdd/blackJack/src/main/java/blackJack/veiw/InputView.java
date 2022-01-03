package blackJack.veiw;

import blackJack.domain.Player;
import blackJack.domain.PlayerName;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    public static final String ERROR_DUPLICATE = "[ERROR] 중복된 이름은 사용 할 수 없습니다.";
    public static final String ERROR_FORMAT = "[ERROR] 양식에 맞춰서 입력해주세요.";
    public static final String INPUT_DELIMITER = ",";
    public static final String ERROR_INVALID_AMOUNT = "[ERROR] 숫자를 입력해주세요.";

    public static List<Player> createPlayer(String s) {
        return Arrays.stream(s.split(INPUT_DELIMITER))
                .map(PlayerName::new)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static void checkDuplication(String s) {
        String[] names = s.split(INPUT_DELIMITER);

        if (new HashSet<>(Arrays.asList(names)).size() != names.length) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    public static void checkFormat(String s) {
        String regex = "[a-zA-Z0-9]+(,[a-zA-Z0-9]+)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_FORMAT);
        }
    }

    public static void checkAmount(String s) {
        if (!s.chars().allMatch(Character::isDigit) || "".equals(s)) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT);
        }
    }
}
