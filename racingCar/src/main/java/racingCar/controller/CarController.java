package racingCar.controller;

import racingCar.domain.Names;
import racingCar.domain.RandomFuel;
import racingCar.domain.Token;
import racingCar.repository.CarRepository;
import racingCar.service.CarService;
import view.CountInputView;
import view.NamesInputView;
import view.ResultView;
import view.WinnerView;

public class CarController {
    private final CarService carService;

    public CarController() {
        this.carService = new CarService(new CarRepository(), new RandomFuel());
    }

    //첫화면
    public Names init() {
        return NamesInputView.show();
    }

    public Token countInputView(Names names) {
        carService.makeCars(names);
        return CountInputView.show();
    }

    public void resultView(Token token) {
         ResultView.show(carService.play(token));
    }

    public void winnerView() {
        WinnerView.show(carService.getWinner());
    }
}
