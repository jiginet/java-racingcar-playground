package study;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    public void showPositionOfCars() {
        for (Car car : cars) {
            System.out.println(showPosition(car));
        }
    }

    private String showPosition(Car car) {
        return car.getName() + " : "
            + String.join("", Collections.nCopies(car.getPosition(), "-"));
    }

    public void showWinners() {
        String winners = cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
