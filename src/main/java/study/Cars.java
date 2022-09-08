package study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private static final int RANDOM_BOUND = 10;
    private final Random random = new Random();
    private final List<Car> cars;

    public Cars(Car... cars) {
        this.cars = Arrays.asList(cars);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        final Car winner = getWinner();
        return cars.stream()
            .filter(car -> car.compareTo(winner) == 0)
            .collect(Collectors.toList());
    }

    public Car getWinner() {
        return cars.stream()
            .max(Comparator.naturalOrder())
            .orElseThrow(() -> new IllegalStateException("우승자를 찾을 수 없습니다."));
    }

    public List<Car> race() {
        return cars.stream()
            .map(car -> car.move(random.nextInt(RANDOM_BOUND)))
            .collect(Collectors.toList());
    }
}
