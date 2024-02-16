package baseball.util;

import java.util.List;
import mallang.missionutils.Randoms;

public class RandomNumberGenerator {

    private final static int START_DIGIT = 1;
    private final static int END_DIGIT = 9;
    private StringBuilder randomNumber;

    private RandomNumberGenerator() {
        randomNumber = new StringBuilder("");
    }

    public static RandomNumberGenerator create() {
        return new RandomNumberGenerator();
    }

    public String getRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_DIGIT, END_DIGIT, 3);
        for(int number : numbers) {
            randomNumber.append(number);
        }
        return randomNumber.toString();
    }
}
