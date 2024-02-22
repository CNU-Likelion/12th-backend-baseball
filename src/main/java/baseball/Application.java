package baseball;

import mallang.missionutils.Console;
import mallang.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        while (true) {
            playGame();

            if (!restartGame()) {
                break;
            }
        }
    }

    private static boolean restartGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String option = Console.readLine();
        return "1".equals(option);
    }

    private static void playGame() {
        List<Integer> answer = generateRandomNumbers();
        System.out.println("숫자 야구 답 : " + answer);

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();
            if (!isValidInput(input)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            List<Integer> guess = parseInput(input);
            String result = getResult(answer, guess);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Set<Integer> uniqueDigits = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            int digit;
            do {
                digit = Randoms.pickNumberInRange(1, 9);
            } while (!uniqueDigits.add(digit));
            numbers.add(digit);
        }
        return numbers;
    }

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

    private static List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    private static String getResult(List<Integer> answer, List<Integer> guess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(guess.get(i))) {
                strike++;
            } else if (guess.contains(answer.get(i))) {
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

    private static boolean contains(int[] array, int num) {
        for (int i : array) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }
}