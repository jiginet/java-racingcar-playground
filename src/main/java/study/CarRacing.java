package study;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private List<Car> joinedCars = new ArrayList<>();

    public void add(Car car) {
        joinedCars.add(car);
    }

    public int getNumberOfJoinedCars() {
        return joinedCars.size();
    }

    public void play(int n) {
        for (int i = 0; i < n; i++) {
            for (Car car : joinedCars) {
                car.forward();
            }
        }
    }

    public List<Car> getWinners() {
        Car winner = joinedCars.stream()
            .max(new Comparator<Car>() {
                @Override
                public int compare(Car car1, Car car2) {
                    return car1.getPosition() - car2.getPosition();
                }
            })
            .orElseThrow(() -> new IllegalStateException("우승자를 가져올 수 없습니다."));

        return joinedCars.stream()
            .filter(car -> car.getPosition() == winner.getPosition())
            .collect(Collectors.toList());
    }
}
