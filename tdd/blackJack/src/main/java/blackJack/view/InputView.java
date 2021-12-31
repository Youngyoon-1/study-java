package blackJack.view;

import blackJack.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Participants initPlayer() {
        emptyLine();
        String names = inputNames();
        List<Participant> participants = generatePlayer(names);
        inputBettingAmount(participants);
        return new Participants(participants);
    }

    private static String inputNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String names = readLine();
        try {
            checkNames(names);
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputNames();
        }
    }

    private static void inputBettingAmount(List<Participant> participants) {
        participants.forEach(participant -> {
            emptyLine();
            String amount = inputBettingAmount(participant);
            participant.setBettingAmount(new BettingAmount(Integer.parseInt(amount)));
        });
    }

    private static String inputBettingAmount(Participant participant) {
        System.out.println(participant + "의 배팅 금액은?");
        String amount = readLine();
        try {
            checkAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBettingAmount(participant);
        }
    }

    private static void checkAmount(String amount) {
        if (!amount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static List<Participant> generatePlayer(String names) {
        return Arrays.stream(names.split(",")).map(Player::new).collect(Collectors.toList());
    }

    private static void checkNames(String names) {
        String regex = "[a-zA-Z]+(,[a-zA-Z]+)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(names);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 양식에 맞도록 다시 입력해주세요.");
        }
    }

    private static String readLine() {
        return scanner.nextLine().replace(" ", "");
    }

    private static void emptyLine() {
        System.out.println();
    }

    public static void pickCard(Participants participants) {
        emptyLine();
        participants.getPlayerCanPickCard().forEach(InputView::pickCard);
        pickCardByDealer(participants);
    }

    private static void pickCardByDealer(Participants participants) {
        if (participants.canPickCardByDealer()) {
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
            participants.pickCardByDealer();
        }
    }

    private static void pickCard(Participant participant) {
        boolean canPickCard = true;
        while (canPickCard) {
            String request = inputYesOrNo(participant);
            canPickCard = pickCard(participant, request);
            System.out.println(participant.showCards());
            emptyLine();
        }
    }

    private static String inputYesOrNo(Participant participant) {
        System.out.println(participant + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String request = readLine();
        try {
            checkRequest(request);
            return request;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputYesOrNo(participant);
        }
    }

    private static void checkRequest(String request) {
        if (!request.equalsIgnoreCase("y") && !request.equalsIgnoreCase("n")) {
            throw new IllegalArgumentException("[ERROR] 'y' 또는 'n' 을 입력해주세요.");
        }
    }

    private static boolean pickCard(Participant participant, String request) {
        if (request.equalsIgnoreCase("y")) {
            participant.pickCard(Deck.getCard());
            return participant.canPickCard();
        }
        return false;
    }
}