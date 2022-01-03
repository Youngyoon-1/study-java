package blackJack.veiw;

import blackJack.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<Player> createPlayer(String s) {
        return Arrays.stream(s.split(",")).map(Player::new).collect(Collectors.toList());
    }
}
