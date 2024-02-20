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
        int ifOneContinueGameSet = 1;
        if (again == 1) {
            ifOneContinueGameSet = 1;
        } else if (again == 2) {
            System.out.println("게임종료");
            ifOneContinueGameSet = 0;
        } else {
            throw new IllegalArgumentException();
        }
        return ifOneContinueGameSet;
    }

    public static void main(String[] args) {

        Hint hint = new Hint();
        BaseballNumber baseballNumber = new BaseballNumber();

        List<Integer> randomNum;
        List<Integer> userNum;

        int ifOneContinueGameSet = 1;
        int ifOneContinueUserSet = 1;

        while (ifOneContinueGameSet == 1) {
            randomNum = new ArrayList<>();
            baseballNumber.pickNum(randomNum);

            while (ifOneContinueUserSet == 1) {
                int strike = 0;
                int ball = 0;

                userNum = new ArrayList<>();

                userNum = baseballNumber.getUserNum();

                strike = hint.countStrike(randomNum, userNum);
                ball = hint.countBall(userNum, randomNum);

                ifOneContinueUserSet = hint.printAnswer(strike, ball);
            }

            int again = askFinish();
            ifOneContinueGameSet = endOrAgain(again);
            ifOneContinueUserSet = 1;
        }
    }
}
