package study;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

    @Test
    void play() {
        System.setIn(new ByteArrayInputStream("a,b,c\n5\n".getBytes()));
        CarRacing carRacing = new CarRacing(new InputView(), new OutputView());
        carRacing.input();
        carRacing.play();
        carRacing.result();
    }
}
