package study;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final int MOVABLE_BASE_NUM = 4;
    private final CarName name;
    private final Distance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new Distance(0);
    }

    public Car(String name, int distance) {
        this.name = new CarName(name);
        this.distance = new Distance(distance);
    }

    public Car(CarName name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car move(int randomNo) {
        if (randomNo < MOVABLE_BASE_NUM) {
            return this;
        }
        return new Car(name, distance.add(1));
    }

    public String getName() {
        return name.getName();
    }

    public Distance getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
            Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    @Override
    public int compareTo(Car other) {
        return distance.compareTo(other.getDistance());
    }

    @Override
    public String toString() {
        return name.getName() + " : " + distance.getDistanceString();
    }
}
