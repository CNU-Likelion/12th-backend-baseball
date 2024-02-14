package baseball;

import java.io.*;
import java.util.*;
import camp.nextstep.edu.missionutils.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 숫자 야구 게임 구현
        /* 서로 다른 3개의 수를 랜덤으로 뽑는다. -> LinkedList로 구현 */

        // 랜덤으로 생성한 수를 넣는 LinkedList
        LinkedList<Integer> randomNum = new LinkedList<>();

        // 사용자에게 입력받은 수를 넣는 LinkedList
        LinkedList<Integer> userNum = new LinkedList<>();

        // 수 중복되지 않게 3가지 뽑기
        while (randomNum.size() != 3) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(ranNum)) {
                randomNum.add(ranNum);
            }
        }

        // user에게 수 입력받기
        String[] userArr = Console.readLine().split("");

        // 3개의 수를 입력받는다. -> 하나하나 빼서 LinkedList에 넣는다.
        // 같은 수가 같은 자리에 있으면 스트라이크, 같은 수가 다른 자리에 있으면 볼
        // 3개의 숫자를 모두 맞히면 종료
        // 잘못된 값을 입력받으면 IllegalArgumentException 출력

    }
}
