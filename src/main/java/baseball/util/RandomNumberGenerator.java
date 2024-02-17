package baseball.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import mallang.missionutils.Randoms;

public class RandomNumberGenerator {

    private final static int START_DIGIT = 1;
    private final static int END_DIGIT = 9;
    private String randomNumber;

    private RandomNumberGenerator() {
        randomNumber = "";
    }

    public static RandomNumberGenerator create() {
        return new RandomNumberGenerator();
    }

    public String setComputerNumber() {
        LinkedHashSet<String> computerNumberCheck = new LinkedHashSet<String>();
        while (computerNumberCheck.size() < 3) {
            computerNumberCheck.add(getRandomNumber());
        }
        this.randomNumber = String.join("", computerNumberCheck);
        return randomNumber;
    }

    private static String getRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(START_DIGIT, END_DIGIT));
    }
}
