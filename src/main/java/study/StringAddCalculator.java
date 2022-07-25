package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isEmptyString(input)) {
            return 0;
        }
        String[] numbers = splitInputString(input);
        return Arrays.stream(numbers)
            .mapToInt(num -> {
                int result = Integer.parseInt(num);
                if (result < 0) {
                    throw new RuntimeException("양수를 입력해주세요.");
                }
                return result;
            })
            .sum();
    }

    private static String[] splitInputString(final String input) {
        String result = input;
        String token = ",|:";
        Pattern pattern = Pattern.compile("//(.)\n");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            token = matcher.group(1);
            result = result.substring(4);
        }
        return result.split(token);
    }

    private static boolean isEmptyString(String input) {
        return input == null || input.isEmpty();
    }

}
