import java.util.List;

public class GameManager {

    private static final GameManager gameManager = new GameManager();

    private GameManager(){}

    public static GameManager getInstance() {
        return gameManager;
    }

    public boolean check3Strike(List<String> result) {
        return result.stream().anyMatch(score -> score.contains("3스트라이크"));
    }
}
