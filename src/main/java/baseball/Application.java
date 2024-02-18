package baseball;

import java.util.*;
import mallang.missionutils.*;
import mallang.missionutils.Console;

public class Application {

    static LinkedList<Integer> randomNum;
    static LinkedList<Integer> userNum;

    static void pickNum() {
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

    static int countStrike() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNum.get(i) == userNum.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    static int countBall() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            cnt += checkBall(i);
        }
        return cnt;
    }

    static int checkBall(int index) {
        if (randomNum.contains(userNum.get(index))) {
            if (index != randomNum.indexOf(userNum.get(index))) {
                return 1;
            }
        }
        return 0;
    }

    static void printAnswer(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        } else if (strike != 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 0 && ball != 0) {
            System.out.printf("%d볼\n", ball);
        } else {
            System.out.printf("낫싱\n");
        }
    }

    public static void main(String[] args) {

        while (true) {

            randomNum = new LinkedList<>();
            pickNum();

            while (true) {
                int strike = 0;
                int ball = 0;

                userNum = new LinkedList<>();

                System.out.printf("숫자를 입력해주세요");
                String[] userArr = Console.readLine().split("");

                checkUserNum(userArr);

                userNum.add(Integer.parseInt(userArr[0]));
                userNum.add(Integer.parseInt(userArr[1]));
                userNum.add(Integer.parseInt(userArr[2]));

                strike = countStrike();
                ball = countBall();

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    break;
                } else {
                    printAnswer(strike, ball);
                }

            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int again = Integer.parseInt(Console.readLine());

            if (again == 1) {
                continue;
            } else if (again == 2) {
                System.out.println("게임종료");
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }

    }
}
