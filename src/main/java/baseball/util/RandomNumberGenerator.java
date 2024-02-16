package baseball.util;

import mallang.missionutils.Randoms;

public class RandomNumberGenerator {

    private final int startDigit = 1;
    private final int endDigit = 9;
    private StringBuilder randomNumber;

    private RandomNumberGenerator() {
        randomNumber = new StringBuilder("");
    }

    public static RandomNumberGenerator create() {
        return new RandomNumberGenerator();
    }

    public String getRandomNumber() {
        for(int i=0; i<3; i++) {
            randomNumber.append(Randoms.pickNumberInRange(startDigit, endDigit));
        }
        return randomNumber.toString();
    }
}
