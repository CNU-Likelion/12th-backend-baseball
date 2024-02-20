package baseball;

import java.util.*;

public class Hint {
    int countStrike(List<Integer> randomNum, List<Integer> userNum) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNum.get(i) == userNum.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    int countBall(List<Integer> userNum, List<Integer> randomNum) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            cnt += isBall(i, userNum, randomNum);
        }
        return cnt;
    }

    int isBall(int index, List<Integer> userNum, List<Integer> randomNum) {
        if (randomNum.contains(userNum.get(index))) {
            if (index != randomNum.indexOf(userNum.get(index))) {
                return 1;
            }
        }
        return 0;
    }

    int printAnswer(int strike, int ball) {
        int ifOneContinueUserSet = 0;
        if (strike == 3) {
            System.out.println("3스트라이크");
            ifOneContinueUserSet = 0;
        } else if (strike != 0 && ball != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            ifOneContinueUserSet = 1;
        } else if (strike != 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            ifOneContinueUserSet = 1;
        } else if (strike == 0 && ball != 0) {
            System.out.printf("%d볼\n", ball);
            ifOneContinueUserSet = 1;
        } else {
            System.out.printf("낫싱\n");
        }
        return ifOneContinueUserSet;
    }
}
