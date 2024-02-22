package baseball;

import java.util.*;
import mallang.missionutils.*;

public class Application {

    public static final int YES = 1;
    public static final int NO = 0;

    public static final int USER_WANT_CONTINUE = 1;
    public static final int USER_WANT_FINISH = 2;

    public static final int NUMBER_OF_CASE = 3;

    private static List<Integer> pickNum() {
        List<Integer> randomNum = new ArrayList<>();
        while (randomNum.size() != NUMBER_OF_CASE) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(ranNum)) {
                randomNum.add(ranNum);
            }
        }
        return randomNum;
    }

    private static List<Integer> getUserNum() {
        System.out.printf("숫자를 입력해주세요");
        String[] userArr = Console.readLine().split("");
        checkUserNum(userArr);
        List<Integer> userNum = new ArrayList<>();
        userNum.add(Integer.parseInt(userArr[0]));
        userNum.add(Integer.parseInt(userArr[1]));
        userNum.add(Integer.parseInt(userArr[2]));
        return userNum;
    }

    private static void checkUserNum(String[] userArr) {
        if (userArr.length != NUMBER_OF_CASE) {
            throw new IllegalArgumentException();
        }
    }

    private static int askFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static int endOrAgain(int again) {
        int continueGameSet = YES;
        if (again == USER_WANT_CONTINUE) {
            continueGameSet = YES;
        } else if (again == USER_WANT_FINISH) {
            System.out.println("게임종료");
            continueGameSet = NO;
        } else {
            throw new IllegalArgumentException();
        }
        return continueGameSet;
    }

    public static void main(String[] args) {

        Hint hint = new Hint();
        BaseballNumber baseballNumber;

        int ContinueGameSet = YES;
        int ContinueUserSet = YES;

        while (ContinueGameSet == YES) {
            baseballNumber = new BaseballNumber();
            baseballNumber.setRandomNum(pickNum());

            while (ContinueUserSet == YES) {
                int numberOfStrike = 0;
                int numberOfBall = 0;

                baseballNumber.setUserNum(getUserNum());

                numberOfStrike = baseballNumber.countStrike();
                numberOfBall = baseballNumber.countBall();

                hint.setNumberOfStrike(numberOfStrike);
                hint.setNumberOfBall(numberOfBall);

                ContinueUserSet = hint.printAnswer();
            }

            int again = askFinish();
            ContinueGameSet = endOrAgain(again);
            ContinueUserSet = YES;
        }
    }
}
