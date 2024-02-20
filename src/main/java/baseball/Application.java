package baseball;

import java.util.*;
import mallang.missionutils.*;

public class Application {

    static int askFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    static int endOrAgain(int again) {
        if (again == 1) {
            return 1;
        } else if (again == 2) {
            System.out.println("게임종료");
            return 0;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

        Hint hint = new Hint();
        BaseballNumber baseballNumber = new BaseballNumber();

        List<Integer> randomNum;
        List<Integer> userNum;

        int doGameSet = 1;
        int doUserSet = 1;

        while (doGameSet == 1) {
            randomNum = new ArrayList<>();
            baseballNumber.pickNum(randomNum);

            while (doUserSet == 1) {
                int strike = 0;
                int ball = 0;

                userNum = new ArrayList<>();

                String[] userArr = baseballNumber.getUserNum();

                baseballNumber.checkUserNum(userArr);
                baseballNumber.addNumToList(userNum, userArr);

                strike = hint.countStrike(randomNum, userNum);
                ball = hint.countBall(userNum, randomNum);

                doUserSet = hint.printAnswer(strike, ball);
            }

            int again = askFinish();
            doGameSet = endOrAgain(again);
            doUserSet = 1;
        }
    }
}
