import util.FormatUtil;
import util.NumberUtil;

import java.util.List;
import java.util.Scanner;

public class GameManager {

    private static final GameManager gameManager = new GameManager();

    private GameManager(){}

    public static GameManager getInstance() {
        return gameManager;
    }

    public boolean check3Strike(List<String> result) {
        return result.stream().anyMatch(score -> score.contains("3스트라이크"));
    }

    public boolean checkNo(String s) {
        if(s.equals("1")){
            return true;
        }
        return false;
    }

    public void play(Scanner sc, List<Integer> actual){
        boolean is3Strike = false;
        while(!is3Strike){
            List<String> result = Score.of(actual,FormatUtil.convertStr(InputView.receiveNos(sc)));
            ResultView.print(result);
            is3Strike = check3Strike(result);
        }
    }

//    public void init(Scanner sc){
//        boolean gameToken = true;
//        while(gameToken){
//            play(sc, NumberUtil.makeNos());
//            ResultView.print();
//            gameToken = checkNo(InputView.receiveNo(sc));
//        }
//    }
}
