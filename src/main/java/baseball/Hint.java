package baseball;

import java.util.*;

public class Hint {

    public int countStrike(List<Integer> randomNum, List<Integer> userNum) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNum.get(i) == userNum.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countBall(List<Integer> userNum, List<Integer> randomNum) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            cnt += checkBall(i, userNum, randomNum);
        }
        return cnt;
    }

    public int checkBall(int index, List<Integer> userNum, List<Integer> randomNum) {
        if (randomNum.contains(userNum.get(index))) {
            if (index != randomNum.indexOf(userNum.get(index))) {
                return 1;
            }
        }
        return 0;
    }

    public int printAnswer(int strike, int ball) {
        int ifOneContinueUserSet = 1;

        if (ball != 0) {
            System.out.printf("%d볼 ", ball);
        }
        if (strike != 0) {
            System.out.printf("%d스트라이크", strike);
            if (strike == 3)
                ifOneContinueUserSet = 0;
        }
        if (ball == 0 && strike == 0) {
            System.out.printf("낫싱");
        }
        System.out.println();

        return ifOneContinueUserSet;
    }
}
