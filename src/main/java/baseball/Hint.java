package baseball;

import java.util.*;

public class Hint {
    public static final int YES = 1;
    public static final int NO = 0;

    public static final int BALL = 1;
    public static final int NOTBALL = 0;

    public static final int NUMBER_OF_CASE = 3;

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

    public int printAnswer(int numberOfStrike, int numberOfBall) {
        int ContinueUserSet = YES;

        if (numberOfBall != 0) {
            System.out.printf("%d볼 ", numberOfBall);
        }
        if (numberOfStrike != 0) {
            System.out.printf("%d스트라이크", numberOfStrike);
            if (numberOfStrike == 3)
                ContinueUserSet = NO;
        }
        if (numberOfBall == 0 && numberOfStrike == 0) {
            System.out.printf("낫싱");
        }
        System.out.println();

        return ContinueUserSet;
    }
}
