package baseball;

import java.util.*;
import mallang.missionutils.*;

public class BaseballNumber {

    void pickNum(List<Integer> randomNum) {
        while (randomNum.size() != 3) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(ranNum)) {
                randomNum.add(ranNum);
            }
        }
    }

    List<Integer> getUserNum() {
        System.out.printf("숫자를 입력해주세요");
        String[] userArr = Console.readLine().split("");
        checkUserNum(userArr);
        List<Integer> userNum = new ArrayList<>();
        userNum.add(Integer.parseInt(userArr[0]));
        userNum.add(Integer.parseInt(userArr[1]));
        userNum.add(Integer.parseInt(userArr[2]));
        return userNum;
    }

    void checkUserNum(String[] userArr) {
        if (userArr.length != 3) {
            throw new IllegalArgumentException();
        }
    }
}
