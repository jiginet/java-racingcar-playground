package study;

import java.util.Random;

public class Car {

    public static final int MAX_NAME_SIZE = 5;
    public static final int MAX_BOUND = 10;
    private final String name;
    private Random random = new Random();
    private int position = 1;

    public Car(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("자동차 이름은 최소 1자 이상이어야 합니다.");
        }
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_SIZE + "자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public boolean canForward(int num) {
        return num >= 4 && num <= 9;
    }

    public void forward() {
        if (canForward(random.nextInt(MAX_BOUND))) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
