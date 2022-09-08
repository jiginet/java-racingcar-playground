package study;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void showCarPosition(List<Car> cars) {
        cars.stream()
            .forEach(System.out::println);
        System.out.println("");
    }

    public void showWinners(List<Car> cars) {
        String winners = cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
