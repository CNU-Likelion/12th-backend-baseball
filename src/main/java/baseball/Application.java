package baseball;
import java.util.*;
import mallang.missionutils.Randoms;
import mallang.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }
    // 1부터 9까지의 서로 다른 임의의 수를 3개 생성해서 배열에 저장
    public int[] answerNum() {
        int[] answer = new int[3];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = Randoms.pickNumberInRange(1,9);
        }
        return answer;
    }
    // 사용자로부터 숫자 입력받아 배열에 저장
    // 사용자가 잘못된 값 입력할 경우 IllegalArgumentException 발생 (만들어야 함)
    public static int[] userNum() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        int[] guess = parseInput(input);
        return guess;
    }
    // 입력받은 String값 Int로 파싱해주기
    public static int[] parseInput(String input) {
        int[] guess = new int[3];
        for(int i = 0; i < guess.length; i++) {
            guess[i] = Character.getNumericValue(input.charAt(i));
        }
        return guess;
    }
    // 정답 확인 함수
    public static int[] checkNum(int[] answer, int[] guess) {
        int[] result = new int[3];
        countBalls(answer, guess, result);
        countStrikes(answer, guess, result);
        result[2] = 3 - result[0] - result[1]; // 낫싱 개수
        return result;
    }
    // 볼 개수
    public static void countBalls(int[] answer, int[] guess, int[] result) {
        for(int i = 0; i < answer.length; i++) {
            for(int j = 0; j < guess.length; j++) {
                if(answer[i] == guess[j] && i != j) {
                    result[0]++;
                }
            }
        }
    }
}
