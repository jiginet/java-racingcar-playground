package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("우승자를 반환한다.(1명 이상 가능)")
    void getWinners() {
        // given
        Car a = new Car("a", 2);
        Car b = new Car("b", 4);
        Car c = new Car("c", 5);
        Car d = new Car("d", 5);

        // when
        Cars cars = new Cars(a, b, c, d);
        List<Car> winners = cars.getWinners();

        // then
        assertThat(winners)
            .hasSize(2)
            .containsExactly(c, d);
    }
}
