package study;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Distance implements Comparable<Distance> {

    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance add(int i) {
        return new Distance(distance + i);
    }

    public int getDistance() {
        return distance;
    }

    public String getDistanceString() {
        return Collections.nCopies(distance, "-").stream()
            .collect(Collectors.joining(""));
    }

    @Override
    public int compareTo(Distance other) {
        return distance - other.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
