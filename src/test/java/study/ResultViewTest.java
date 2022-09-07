package study;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        // System.out.println() 으로 출력되는 값을 검증하기 위해 필요함
        System.setOut(new PrintStream(outContent));

        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));

        for (Car car : cars) {
            for (int i = 0; i < 10; i++) {
                car.forward();
            }
        }
    }

    @AfterEach
    void tearDown() {
        // OutputStream 을 원래대로 돌려놓는다.
        System.setOut(originalOut);
    }


    @Test
    @DisplayName("자동차의 위치를 표시해준다.")
    void showCarPosition() {
        // given
        ResultView view = new ResultView(cars);

        // when
        view.showPositionOfCars();

        // then
        Assertions.assertThat(outContent.toString())
            .contains(": -")
            .containsPattern(".+ : \\-+");
    }

    @Test
    @DisplayName("자동차 경주 우승자를 표시해준다.")
    void showRacingWinners() {
        // given
        ResultView view = new ResultView(cars);

        // when
        view.showWinners();

        // then
        Assertions.assertThat(outContent.toString())
            .contains("가 최종 우승했습니다.");
    }

    @Test
    @DisplayName("Collections.nCopies 학습")
    void nCopies() {
        List<String> strings = Collections.nCopies(3, "-");
        System.out.println("strings = " + strings);
    }
}
