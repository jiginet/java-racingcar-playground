package study;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String input = scanner.nextLine();
        return input.split(",");
    }

    public int readPlayCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();
        return count;
    }
}
