package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        Count count = new Count();
        HandleUserNum handleUserNum = new HandleUserNum();
        HandleRandomNum handleRandomNum = new HandleRandomNum();
        HandleProgress handleProgress = new HandleProgress();

        List<Integer> randomNum;
        List<Integer> userNum;

        int doGameSet = 1;
        int doUserSet = 1;

        while (doGameSet == 1) {
            randomNum = new ArrayList<>();
            handleRandomNum.pickNum(randomNum);

            while (doUserSet == 1) {
                int strike = 0;
                int ball = 0;

                userNum = new ArrayList<>();

                String[] userArr = handleUserNum.getUserNum();

                handleUserNum.checkUserNum(userArr);
                handleUserNum.addNumToList(userNum, userArr);

                strike = count.countStrike(randomNum, userNum);
                ball = count.countBall(userNum, randomNum);

                doUserSet = handleProgress.printAnswer(strike, ball);
            }

            int again = handleProgress.askFinish();
            doGameSet = handleProgress.endOrAgain(again);
            doUserSet = 1;
        }
    }
}
