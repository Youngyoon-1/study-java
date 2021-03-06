package blackJack.veiw;

import blackJack.domain.BettingAmount;
import blackJack.domain.BlackJackGame;
import blackJack.domain.Player;
import blackJack.domain.PlayerName;
import blackJack.domain.Players;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    public static final String ERROR_DUPLICATE = "[ERROR] 중복된 이름은 사용 할 수 없습니다.";
    public static final String ERROR_FORMAT = "[ERROR] 양식에 맞춰서 입력해주세요.";
    public static final String INPUT_DELIMITER = ",";
    public static final String ERROR_INVALID_AMOUNT = "[ERROR] 숫자를 입력해주세요.";
    public static final String ERROR_NOT_YES_OR_NO = "[ERROR] 'y' 또는 'n'을 입력해주세요.";
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String YES = "y";
    public static final String NO = "n";

    private static final Scanner scanner = new Scanner(System.in);

    public static Players initPlayer() {
        List<Player> players = inputBettingAmount(createPlayer());
        return new Players(players);
    }

    private static List<Player> inputBettingAmount(List<Player> players) {
        players.forEach(player -> {
            emptyLine();
            setBettingAmount(player);
        });

        return players;
    }

    private static void emptyLine() {
        System.out.println();
    }

    private static void setBettingAmount(Player player) {
        System.out.println(player + "의 배팅 금액은?");
        String input = readLine();
        try {
            checkAmount(input);
            player.setBettingAmount(new BettingAmount(Integer.parseInt(input)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBettingAmount(player);
        }
    }

    private static List<Player> createPlayer() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String input = readLine();
        try {
            checkValidate(input);
            return createPlayer(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createPlayer();
        }
    }

    private static void checkValidate(String input) {
        checkFormat(input);
        checkDuplication(input);
    }

    private static String readLine() {
        return scanner.nextLine().replace(SPACE, EMPTY);
    }

    public static List<Player> createPlayer(String s) {
        return Arrays.stream(s.split(INPUT_DELIMITER))
                .map(PlayerName::new)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static void checkFormat(String s) {
        String regex = "[a-zA-Z0-9]+(,[a-zA-Z0-9]+)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_FORMAT);
        }
    }

    public static void checkDuplication(String s) {
        String[] names = s.split(INPUT_DELIMITER);

        if (new HashSet<>(Arrays.asList(names)).size() != names.length) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    public static void checkAmount(String s) {
        if (!s.chars().allMatch(Character::isDigit) || EMPTY.equals(s)) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT);
        }
    }

    public static void pickCard(BlackJackGame blackJackGame) {
        blackJackGame.players().forEach(player -> {
            pickCard(blackJackGame, player);
        });
        emptyLine();
        blackJackGame.dealerPickCard();
    }

    private static void pickCard(BlackJackGame blackJackGame, Player player) {
        while (player.canPickCard()) {
            emptyLine();
            String request = inputYesOrNo(player);
            pickCard(blackJackGame, player, request);
            System.out.println(player.showCard());
        }
    }

    private static String inputYesOrNo(Player player) {
        System.out.println(player + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String request = readLine();
        try {
            checkYesOrNo(request);
            return request;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputYesOrNo(player);
        }
    }

    private static void pickCard(BlackJackGame blackJackGame, Player player, String request) {
        if (request.equalsIgnoreCase(YES)) {
            blackJackGame.pickCard(player);
        }
        if (request.equalsIgnoreCase(NO)) {
            player.stay();
        }
    }

    public static void checkYesOrNo(String s) {
        if (!s.equalsIgnoreCase(YES) && !s.equalsIgnoreCase(NO)) {
            throw new IllegalArgumentException(ERROR_NOT_YES_OR_NO);
        }
    }
}
