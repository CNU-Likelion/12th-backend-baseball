package baseball;

import java.util.List;

class Count {

    int countBall(List<Integer> userNum, List<Integer> randomNum) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            cnt += checkBall(i, userNum, randomNum);
        }
        return cnt;
    }

    int checkBall(int index, List<Integer> userNum, List<Integer> randomNum) {
        if (randomNum.contains(userNum.get(index))) {
            if (index != randomNum.indexOf(userNum.get(index))) {
                return 1;
            }
        }
        return 0;
    }

    int countStrike(List<Integer> randomNum, List<Integer> userNum) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNum.get(i) == userNum.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
