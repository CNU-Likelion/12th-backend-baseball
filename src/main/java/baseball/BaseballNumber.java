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

    String[] getUserNum() {
        System.out.printf("숫자를 입력해주세요");
        return Console.readLine().split("");
    }

    void checkUserNum(String[] userArr) {
        if (userArr.length != 3) {
            throw new IllegalArgumentException();
        }
    }

    List<Integer> addNumToList(List<Integer> userNum, String[] userArr) {
        userNum.add(Integer.parseInt(userArr[0]));
        userNum.add(Integer.parseInt(userArr[1]));
        userNum.add(Integer.parseInt(userArr[2]));
        return userNum;
    }
}
