package utils;

import java.util.Arrays;

public class ValidationUtil {
    public static String checkMainStationLinePage(String choice) {
        String[] standards = new String[] {"1", "2", "3", "B"};
        return  Arrays.stream(standards)
            .filter(standard -> standard.equalsIgnoreCase(choice))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 다시 입력해주세요."));
    }

    public static String checkStationLineName(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 두 글자 이상을 입력해주세요.");
        }
        return name;
    }

    public static String checkMainSectionPage(String choice) {
        String[] standards = new String[] {"1", "2", "B"};
        return  Arrays.stream(standards)
            .filter(standard -> standard.equalsIgnoreCase(choice))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 다시 입력해주세요."));
    }

    public static String checkNumber(String input) {
        if(!input.chars().allMatch(Character::isDigit) || input.equals("0")) {
            throw new IllegalArgumentException("[ERROR] 1 이상의 숫자를 입력해주세요.");
        }
        return input;
    }

    public static String checkIndexPage(String choice) {
        String[] standards = new String[] {"1", "2", "3", "4", "Q"};
        return  Arrays.stream(standards)
            .filter(standard -> standard.equalsIgnoreCase(choice))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 다시 입력해주세요."));
    }
}
