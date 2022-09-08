package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차에 이름을 부여할 수 있다.")
    void hasCarName() {

        Car hong = new Car("hong");
        Car sameHong = new Car("hong");
        Car gil = new Car("gil");

        assertThat(hong).isNotEqualTo(gil);
        assertThat(hong).isEqualTo(sameHong);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void validateCarName() {

        assertThatThrownBy(() -> new Car("long name"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름과 거리를 부여할 수 있다.")
    void hasCarNameAndDistance() {
        Car hong = new Car("hong", 3);
        Car gil = new Car("gil", 3);
        Car sameHong = new Car("hong", 3);
        Car diffrentDistance = new Car("hong", 4);

        assertThat(hong).isEqualTo(sameHong);
        assertThat(hong).isNotEqualTo(gil);
        assertThat(hong).isNotEqualTo(diffrentDistance);
    }

    @Test
    @DisplayName("랜덤번호가 4이상인 경우 1칸 움직일 수 있다.")
    void canMove() {
        Car car = new Car("abc", 0);
        car = car.move(5);
        assertThat(car.getDistance())
            .isEqualTo(new Distance(1));

        car = car.move(4);
        assertThat(car.getDistance())
            .isEqualTo(new Distance(2));
    }

    @Test
    @DisplayName("랜덤번호가 4미만인 경우 움직일 수 없다.")
    void canNotMove() {
        Car car = new Car("abc", 0);
        car = car.move(3);
        assertThat(car.getDistance())
            .isEqualTo(new Distance(0));
    }
}
