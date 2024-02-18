package baseball;

import java.util.*;
import mallang.missionutils.*;
import mallang.missionutils.Console;

public class Application {

    static void pickNum(List<Integer> randomNum) {
        while (randomNum.size() != 3) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(ranNum)) {
                randomNum.add(ranNum);
            }
        }
    }

    static void checkUserNum(String[] userArr) {
        if (userArr.length != 3) {
            throw new IllegalArgumentException();
        }

    }

    static int countStrike(List<Integer> randomNum, List<Integer> userNum) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNum.get(i) == userNum.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    static int countBall(List<Integer> userNum, List<Integer> randomNum) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            cnt += checkBall(i, userNum, randomNum);
        }
        return cnt;
    }

    static int checkBall(int index, List<Integer> userNum, List<Integer> randomNum) {
        if (randomNum.contains(userNum.get(index))) {
            if (index != randomNum.indexOf(userNum.get(index))) {
                return 1;
            }
        }
        return 0;
    }

    static int printAnswer(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            return 0;
        } else if (strike != 0 && ball != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        } else if (strike != 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 0 && ball != 0) {
            System.out.printf("%d볼\n", ball);
        } else {
            System.out.printf("낫싱\n");
        }
        return 1;
    }

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

    static List<Integer> addNumToList(List<Integer> userNum, String[] userArr) {
        userNum.add(Integer.parseInt(userArr[0]));
        userNum.add(Integer.parseInt(userArr[1]));
        userNum.add(Integer.parseInt(userArr[2]));

        return userNum;
    }

    static String[] getUserNum() {
        System.out.printf("숫자를 입력해주세요");
        return Console.readLine().split("");
    }

    public static void main(String[] args) {

        List<Integer> randomNum;
        List<Integer> userNum;

        int doGameSet = 1;
        int doUserSet = 1;

        while (doGameSet == 1) {
            randomNum = new ArrayList<>();
            pickNum(randomNum);

            while (doUserSet == 1) {
                int strike = 0;
                int ball = 0;

                userNum = new ArrayList<>();

                String[] userArr = getUserNum();

                checkUserNum(userArr);
                addNumToList(userNum, userArr);

                strike = countStrike(randomNum, userNum);
                ball = countBall(userNum, randomNum);

                doUserSet = printAnswer(strike, ball);
            }

            int again = askFinish();
            doGameSet = endOrAgain(again);
            doUserSet = 1;

        }
    }
}
