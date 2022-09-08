package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private final InputView inputView;
    private final OutputView outputView;
    private int playCount;
    private Cars cars;

    public CarRacing(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void input() {
        String[] carNames = inputView.readCarNames();
        this.playCount = inputView.readPlayCount();

        List<Car> carList = Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
        this.cars = new Cars(carList);
    }

    public void play() {
        for (int i = 0; i < playCount; i++) {
            List<Car> racedCars = cars.race();
            outputView.showCarPosition(racedCars);
            cars = new Cars(racedCars);
        }
    }

    public void result() {
        outputView.showWinners(cars.getWinners());
    }
}
