package baseball;

import java.util.*;
import mallang.missionutils.*;

public class BaseballNumber {

    public static final int NUMBER_OF_CASE = 3;

    public static final int BALL = 1;
    public static final int NOTBALL = 0;

    public void pickNum(List<Integer> randomNum) {
        while (randomNum.size() != NUMBER_OF_CASE) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(ranNum)) {
                randomNum.add(ranNum);
            }
        }
    }

    public int countStrike(List<Integer> randomNum, List<Integer> userNum) {
        int cnt = 0;
        for (int i = 0; i < NUMBER_OF_CASE; i++) {
            if (randomNum.get(i) == userNum.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countBall(List<Integer> userNum, List<Integer> randomNum) {
        int cnt = 0;
        for (int i = 0; i < NUMBER_OF_CASE; i++) {
            if (checkBall(i, userNum, randomNum) == BALL) {
                cnt++;
            }
        }
        return cnt;
    }

    public int checkBall(int index, List<Integer> userNum, List<Integer> randomNum) {
        if (randomNum.contains(userNum.get(index))) {
            if (index != randomNum.indexOf(userNum.get(index))) {
                return BALL;
            }
        }
        return NOTBALL;
    }
}
