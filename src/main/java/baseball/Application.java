package baseball;

import java.io.*;
import java.util.*;
import camp.nextstep.edu.missionutils.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    static LinkedList<Integer> randomNum;
    static LinkedList<Integer> userNum;

    static void pickNum() {
        // 수 중복되지 않게 3가지 뽑기
        while (randomNum.size() != 3) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(ranNum)) {
                randomNum.add(ranNum);
            }
        }
    }

    static void checkUserNum(String[] userArr) {
        if (userArr.length != 3) {
            throw new IllegalArgumentException();
        }

    }

    static int countStrike() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNum.get(i) == userNum.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // TODO: 숫자 야구 게임 구현
        while (true) {
            /* 서로 다른 3개의 수를 랜덤으로 뽑는다. -> LinkedList로 구현 */

            // 랜덤으로 생성한 수를 넣는 LinkedList
            randomNum = new LinkedList<>();
            pickNum();

            while (true) {
                int strike = 0;
                int ball = 0;

                // 사용자에게 입력받은 수를 넣는 LinkedList
                userNum = new LinkedList<>();

                // user에게 수 입력받기
                System.out.printf("숫자를 입력해주세요");
                String[] userArr = Console.readLine().split("");

                // 사용자가 수를 잘못 입력했는지 확인
                checkUserNum(userArr);

                // 입력받은 수를 LinkedList에 넣기
                userNum.add(Integer.parseInt(userArr[0]));
                userNum.add(Integer.parseInt(userArr[1]));
                userNum.add(Integer.parseInt(userArr[2]));

                // 같은 수가 같은 자리에 있으면 스트라이크, 같은 수가 다른 자리에 있으면 볼
                strike = countStrike();

                // 3개의 숫자를 모두 맞히면 종료
                // 잘못된 값을 입력받으면 IllegalArgumentException 출력

            }

        }

    }
}
