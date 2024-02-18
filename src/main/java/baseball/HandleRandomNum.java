package baseball;

import java.util.*;
import mallang.missionutils.*;

class HandleRandomNum {

    void pickNum(List<Integer> randomNum) {
        while (randomNum.size() != 3) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(ranNum)) {
                randomNum.add(ranNum);
            }
        }
    }
}