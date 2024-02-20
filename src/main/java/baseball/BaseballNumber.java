package baseball;

import java.util.*;
import mallang.missionutils.*;

public class BaseballNumber {

    public static final int NUMBER_OF_CASE = 3;

    public void pickNum(List<Integer> randomNum) {
        while (randomNum.size() != NUMBER_OF_CASE) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(ranNum)) {
                randomNum.add(ranNum);
            }
        }
    }

    public List<Integer> getUserNum() {
        System.out.printf("숫자를 입력해주세요");
        String[] userArr = Console.readLine().split("");
        checkUserNum(userArr);
        List<Integer> userNum = new ArrayList<>();
        userNum.add(Integer.parseInt(userArr[0]));
        userNum.add(Integer.parseInt(userArr[1]));
        userNum.add(Integer.parseInt(userArr[2]));
        return userNum;
    }

    public void checkUserNum(String[] userArr) {
        if (userArr.length != NUMBER_OF_CASE) {
            throw new IllegalArgumentException();
        }
    }
}
