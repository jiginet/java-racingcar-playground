package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("Random 학습")
    void random() {
        Random random = new Random();

        //  int 난수 반환
        for (int i = 0; i < 100; i++) {
            assertThat(random.nextInt())
                .isBetween(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        // 0 ~ 9 사이의 정수 반환
        for (int i = 0; i < 100; i++) {
            assertThat(random.nextInt(10))
                .isGreaterThanOrEqualTo(0)
                .isLessThan(10);
        }

        // boolean 난수 반환
        for (int i = 0; i < 100; i++) {
            assertThat(random.nextBoolean()).isIn(true, false);
        }

        //  long 난수 반환 (nextFloat, nextDouble, nextBytes 가 더 있다)
        for (int i = 0; i < 100; i++) {
            assertThat(random.nextLong())
                .isBetween(Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }

    @Test
    @DisplayName("assertion 학습")
    void assertion() {

        // 정규식을 이용한 문자열 검증
        Assertions.assertThat("abcd").containsPattern("a.*");
        Assertions.assertThat("abcd").doesNotContainPattern("f.*");

        // 정규식을 이용한 문자열 검증
        Pattern pattern = Pattern.compile("^a.*d$");
        Assertions.assertThat("abcd").containsPattern(pattern);
        Assertions.assertThat("abcdf").doesNotContainPattern(pattern);

        // 문자열 포함여부 검증
        Assertions.assertThat("abc").contains("a", "b");
        Assertions.assertThat("abc").doesNotContain("d", "f");

        // array, set, list도 사용가능
        Assertions.assertThat(Arrays.asList("a", "b", "c")).contains("a", "b");
        Assertions.assertThat(Arrays.asList("a", "b", "c")).doesNotContain("d", "f");

        // containsOnly : 원소의 개수와 값이 일치함
        Assertions.assertThat(new int[]{1, 2, 3}).containsOnly(1, 2, 3);
        Assertions.assertThat(new int[]{1, 2, 3}).containsOnly(3, 2, 1);

        // containsExactly : 원소의 순서, 개수, 값이 일치함
        Assertions.assertThat(new int[]{1, 2, 3}).containsExactly(1, 2, 3);

    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void nameLimit() {
        Car car = new Car("abcde");
        assertThat(car.getName()).hasSize(5);

        assertThatThrownBy(() -> new Car("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름은 최소 1자 이상이어야 한다.")
    void nameLimit2() {
        assertThatThrownBy(() -> new Car(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전진조건은 0~9사이의 값 중 4이상이어야 한다.")
    void forwardTest() {
        Car car = new Car("hello");
        assertThat(car.canForward(-1)).isFalse();
        assertThat(car.canForward(0)).isFalse();
        assertThat(car.canForward(3)).isFalse();
        assertThat(car.canForward(4)).isTrue();
        assertThat(car.canForward(9)).isTrue();
        assertThat(car.canForward(10)).isFalse();
    }

}
