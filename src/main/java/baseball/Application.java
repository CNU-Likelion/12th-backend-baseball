package baseball;

import java.util.*;
import mallang.missionutils.*;

public class Application {

    public static final int YES = 1;
    public static final int NO = 0;

    public static final int USER_WANT_CONTINUE = 1;
    public static final int USER_WANT_FINISH = 2;

    private static int askFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static int endOrAgain(int again) {
        int ContinueGameSet = YES;
        if (again == USER_WANT_CONTINUE) {
            ContinueGameSet = YES;
        } else if (again == USER_WANT_FINISH) {
            System.out.println("게임종료");
            ContinueGameSet = NO;
        } else {
            throw new IllegalArgumentException();
        }
        return ContinueGameSet;
    }

    public static void main(String[] args) {

        Hint hint = new Hint();
        BaseballNumber baseballNumber = new BaseballNumber();

        List<Integer> randomNum;
        List<Integer> userNum;

        int ContinueGameSet = YES;
        int ContinueUserSet = YES;

        while (ContinueGameSet == YES) {
            randomNum = new ArrayList<>();
            baseballNumber.pickNum(randomNum);

            while (ContinueUserSet == YES) {
                int numberOfStrike = 0;
                int numberOfBall = 0;

                userNum = baseballNumber.getUserNum();

                numberOfStrike = hint.countStrike(randomNum, userNum);
                numberOfBall = hint.countBall(userNum, randomNum);

                ContinueUserSet = hint.printAnswer(numberOfStrike, numberOfBall);
            }

            int again = askFinish();
            ContinueGameSet = endOrAgain(again);
            ContinueUserSet = YES;
        }
    }
}
