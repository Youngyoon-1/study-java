import racingCar.controller.CarController;
import racingCar.domain.Names;
import racingCar.domain.Token;
import racingCar.repository.CarRepository;
import racingCar.service.CarService;

public class Adapter {
    CarController carController;

    public Adapter() {
        carController = new CarController();
    }

    public void run() {
        Names names = carController.init();
        Token token = carController.countInputView(names);
        carController.resultView(token);
        carController.winnerView();
    }
}
