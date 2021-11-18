import java.util.Scanner;

public class Application {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        GameManager gm = GameManager.getInstance();
        gm.init(sc);
    }
}
