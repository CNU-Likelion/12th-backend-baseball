package baseball;

import java.util.List;
import mallang.missionutils.*;

public class HandleUserNum {
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
