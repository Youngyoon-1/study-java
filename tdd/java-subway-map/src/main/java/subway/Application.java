package subway;

public class Application {
    public static void main(String[] args) {
        InitData.load();
        Adapter adapter = new Adapter();
        adapter.run();
    }
}
