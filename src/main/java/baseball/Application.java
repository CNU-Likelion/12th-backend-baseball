package baseball;

import mallang.missionutils.Console;
import mallang.missionutils.Randoms;


public class Application {
    private static final int DIGITS = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static void main(String[] args) {
        playGame();
    }


    private static void playGame() {
        int[] computerNumbers = generateComputerNumbers();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();
                int[] guess;
                try {
                    guess = parseUserInput(userInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("값이 잘못 입력되었습니다");
                    continue;
                }

                int strikes = countStrikes(guess, computerNumbers);
                int balls = countBalls(guess, computerNumbers);

                printGameResult(strikes, balls);

                if (isGameOver(strikes)) {
                    if (!reGame()) {
                        break;
                    } else {
                        computerNumbers = generateComputerNumbers(); // 새로운 게임을 시작하기 위해 컴퓨터의 숫자를 다시 생성
                    }
                }
            }



    }

    //컴퓨터 난수 생성
     private static int[] generateComputerNumbers() {

        int[] numbers = new int[DIGITS];
        for (int i = 0; i < DIGITS; i++) {
            numbers[i] = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--; // 중복된 숫자가 나올경우 다시 실행
                    break;
                }
            }
        }
        return numbers;
    }

    private static int[] parseUserInput(String userInput) {
        if (userInput.length() != DIGITS)
            throw new IllegalArgumentException("입력한 숫자의 길이가 올바르지 않습니다.");

        int[] numbers = new int[DIGITS];
        for (int i = 0; i < DIGITS; i++) {
            char digitChar = userInput.charAt(i);
            if (!Character.isDigit(digitChar))
                throw new IllegalArgumentException("입력한 값이 숫자가 아닙니다.");
            numbers[i] = Character.getNumericValue(digitChar);
        }
        return numbers;
    }

    private static int countStrikes(int[] guess, int[] computerNumbers) {
        int count = 0;
        for (int i = 0; i < DIGITS; i++) {
            if (guess[i] == computerNumbers[i])
                count++;
        }
        return count;
    }

    private static int countBalls(int[] guess, int[] computerNumbers) {
        int count = 0;
        for (int i = 0; i < DIGITS; i++) {
            for (int j = 0; j < DIGITS; j++) {
                if (i != j && guess[i] == computerNumbers[j])
                    count++;
            }
        }
        return count;
    }

    private static boolean isGameOver(int strikes) {
        return strikes == DIGITS;
    }

    private static void printGameResult(int strikes, int balls) {
        System.out.println(strikes + " 스트라이크 " + balls + " 볼 " + (DIGITS - strikes - balls) + " 낫싱 ");
    }

    private static boolean reGame() {
        while (true) {
            System.out.print("게임을 다시 하시겠습니까? (1: 다시 시작, 2: 종료): ");
            String input = Console.readLine();
            if (input.equals("1")) {
                return true;
            } else if (input.equals("2")) {
                return false;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

}