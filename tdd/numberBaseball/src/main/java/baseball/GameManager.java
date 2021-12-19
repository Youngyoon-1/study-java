package baseball;

import util.NumberUtil;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class GameManager {

    public static void init(Scanner sc){
        boolean token = true;
        while(token){
            Nos com = new Nos(NumberUtil.makeNos());
            play(sc,com);
            token = new Token(InputView.choice(sc)).read().isRestart();
        }
    }

    private static void play(Scanner sc, Nos com){
        boolean toggle = false;
        while(!toggle){
            Scores scores = new Nos(InputView.input(sc)).compareTo(com);
            OutputView.print(scores.toString());
            toggle = scores.is3Strike();
        }
    }
}
