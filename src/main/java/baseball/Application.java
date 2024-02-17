package baseball;

import mallang.missionutils.Console;
import mallang.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        while (true) {
            //게임 실행
            playGame();

            //게임 종료 후 옵션 선택
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String option = Console.readLine();
            if ("2".equals(option)) {
                break;
            }
        }
    }

    /*게임 메소드*/
    private static void playGame() {
        //임의의 3자리 수 생성
        int[] answer = generateRandomNumbers();
        System.out.println("숫자 야구 답 : " + Arrays.toString(answer));

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();
            //입력값 유효성 검사
            if (!isValidInput(input)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            //임의의 수와 입력값 비교
            int[] guess = parseInput(input);
            String result = getResult(answer, guess);
            System.out.println(result);

            //게임 종료
            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    /*임의의 수 생성하는 메소드*/
    private static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        Set<Integer> uniqueDigits = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            int digit;
            do {
                digit = Randoms.pickNumberInRange(1, 9);
            } while (!uniqueDigits.add(digit));
            numbers[i] = digit;
        }
        return numbers;
    }

    /*입력값 유효성 검사 메소드*/
    private static boolean isValidInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || input.chars().distinct().count() != 3) {
                throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력하세요.");
            }
        }
        return true;
    }

    /*입력값 파싱하는 메소드*/
    private static int[] parseInput(String input) {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }
        return numbers;
    }

    /*값 비교하여 힌트 얻는 메소드*/
    private static String getResult(int[] answer, int[] guess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (answer[i] == guess[i]) {
                strike++;
            } else if (contains(answer, guess[i])) {
                ball++;
            }
        }
        if (strike > 0 && ball > 0) {
            return ball + "볼 " + strike + "스트라이크 ";
        } else if (strike > 0) {
            return strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else {
            return "낫싱";
        }
    }

    /*볼 체크*/
    private static boolean contains(int[] array, int num) {
        for (int i : array) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }
}