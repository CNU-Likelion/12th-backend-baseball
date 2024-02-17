package baseball;
import mallang.missionutils.Randoms;
import mallang.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        startGame();
    }
    // 게임 시작
    public static void startGame() {
        int[] answer = answerNum();

        while(true) {
            int[] guess = userNum();
            int[] result = checkNum(answer, guess);
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
    // 1부터 9까지의 서로 다른 임의의 수를 3개 생성해서 배열에 저장 (숫자가 겹치지 않도록 수정)
    public static int[] answerNum() {
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
        int choice = Integer.parseInt(Console.readLine());
        return choice == 1;
    }

}
