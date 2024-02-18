package baseball;

import mallang.missionutils.*;

class HandleProgress {

    int printAnswer(int strike, int ball) {
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

    int askFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    int endOrAgain(int again) {
        if (again == 1) {
            return 1;
        } else if (again == 2) {
            System.out.println("게임종료");
            return 0;
        } else {
            throw new IllegalArgumentException();
        }
    }
}