package blackJack.veiw;

import blackJack.domain.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static final String ERROR_DUPLICATE = "[ERROR] 중복된 이름은 사용 할 수 없습니다.";

    public static List<Player> createPlayer(String s) {
        return Arrays.stream(s.split(",")).map(Player::new).collect(Collectors.toList());
    }

    public static void checkDuplication(String s) {
        String[] names = s.split(",");

        if (new HashSet<>(Arrays.asList(names)).size() != names.length) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }
}
