package study;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

    CarRacing carRacing = new CarRacing();

    @BeforeEach
    void setUp() {
        carRacing.add(new Car("pobi"));
        carRacing.add(new Car("crong"));
        carRacing.add(new Car("honux"));
    }

    @Test
    @DisplayName("레이싱에 자동차를 참가시킬 수 있다.")
    void readCarName() {
        // given
        CarRacing carRacing = new CarRacing();
        carRacing.add(new Car("abc"));
        carRacing.add(new Car("def"));

        // when
        int numOfCars = carRacing.getNumberOfJoinedCars();

        // then
        Assertions.assertThat(numOfCars).isEqualTo(2);
    }

    @Test
    @DisplayName("레이싱 게임을 진행하고, 우승자를 반환한다.")
    void playTest() {
        // given
        carRacing.play(5);

        // when
        List<Car> winners = carRacing.getWinners();

        // then
        Assertions.assertThat(winners.size() > 0).isTrue();
    }

}
