package baseball;
import java.util.*;
import mallang.missionutils.Randoms;
import mallang.missionutils.Console;

import static mallang.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        startGame();
    }
    // 게임 시작
    public static void startGame() {
        List<Integer> answerNum = answerNum();

        while(true) {
            List<Integer> userNum = new ArrayList<>();
            List<Integer> result = checkNum(answer, userNum);
            printResult(result);

            if (result[2] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 ");
                break;
            }
            if(!continueGame()) {
                break;
            }
        }
    }
    public static ArrayList<Integer> createNum() { // 변경 O
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < answer.size(); i++) {
            answer.set(i, Randoms.pickNumberInRange(1, 9));
        }
        return answer;
    }

    public static ArrayList<Integer> userNum() {
        String input;
        System.out.println("숫자를 입력해주세요 : ");

        input = readLine();
        if(input.length() > 3) {
            throw new IllegalArgumentException();
        }
        alreadyNum(input);
        ArrayList<Integer> guess = parseInput(input);
        return guess;
    }
    public static void alreadyNum(String input) { // 변경 O
        boolean containNum;
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            int idx = Integer.parseInt(String.valueOf(input.charAt(i)));

            containNum = !(nums.contains(idx));
            if(containNum) {
                nums.add(idx);
            }
            else {
                throw new IllegalArgumentException();
            }
        }
    }
    public static ArrayList<Integer> parseInput(String input) {
        ArrayList<Integer> guess = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            char num = input.charAt(i);
            String strNum = String.valueOf(num);
            if(checkInput(strNum, 1, 9)) {
                guess.add(Integer.parseInt(strNum));
            }
        }
        return guess;
    }
    // 정답 확인 함수
    public static List<Integer> checkNum(List<Integer> answer, List<Integer> guess) {
        int[] result = new int[3];
        countBalls(answer, guess, result);
        countStrikes(answer, guess, result);
        result[2] = 3 - result[0] - result[1]; // 낫싱 개수
        return result;
    }
    // 볼 개수
    public static void countBalls(List<Integer> answer, List<Integer> guess, List<Integer> result) {
        for(int i = 0; i < answer.size(); i++) {
            for(int j = 0; j < guess.size(); j++) {
                if(answer.get(i) == guess.get(j) && i != j) {
                    result.get(0)++;
                }
            }
        }
    }
    // 스트라이크 개수
    public static void countStrikes(int[] answer, int[] guess, int[] result) {
        for(int i = 0; i < answer.length; i++){
            if(answer[i] == guess[i]) {
                result[1]++;
            }
        }
    }
    // 결과 출력 (출력 수정 필요)
    public static void printResult(int[] result) {
        System.out.println(result[0] + "볼" + " " + result[1] + "스트라이크" + result[2] + "낫싱");
    }
    // 게임 재시작 여부
    public static boolean continueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = readLine();

        if (restart.length() != 1) {
            throw new IllegalArgumentException();
        }

    }
}
