package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	private static final int MIN = 1;
	private static final int MAX = 9;
	private static final int BALL_SIZE = 3;

	public static void main(String[] args) {
		while (true) {
			playGame();
		}
	}

	/* 게임 메소드 */
	private static void playGame() {
		// 랜덤 3자리 숫자 생성
		int computerBall[] = generateRandomBall();
		System.out.println("랜덤 숫자 : " + Arrays.toString(computerBall));

		while (true) {
			// 사용자 입력 3자리 숫자
			int[] userBall = getUserInput();
			checkBall(userBall);

			// 볼, 스트라이크, 낫싱 체크
			int ballScore = ballCheck(computerBall, userBall);
			int strikeScore = strikeCheck(computerBall, userBall);

			// 힌트 출력
			if (strikeScore != 0 && ballScore == 0) {
				System.out.println(strikeScore + "스트라이크");
			} else if (strikeScore == 0 && ballScore != 0) {
				System.out.println(ballScore + "볼");
			} else if (strikeScore == 3) {
				System.out.println(strikeScore + "스트라이크");
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				playAgain();
			} else if (strikeScore == 0 && ballScore == 0) {
				System.out.println("낫싱");
			} else {
				System.out.println(ballScore + "볼" + strikeScore + "스트라이크");
			}
		}
	}

	/* 게임 반복 메소드 */
	private static void playAgain() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String inputNum = Console.readLine();
		if (inputNum.equals("1")) {
			playGame();
		} else {
			System.exit(0);
		}
	}

	/* 랜덤 3자리 숫자 생성 메소드 */
	private static int[] generateRandomBall() {
		Set<Integer> set = new HashSet<>();
		int[] randomBall = new int[3];
		int count = 0;
		while (count < 3) {
			int number = Randoms.pickNumberInRange(1, 9);
			if (!set.contains(number)) {    // 중복이 없을 경우
				randomBall[count] = number;
				set.add(number);
				count++;
			}
		}
		return randomBall;
	}

	/* 사용자 입력 3자리 숫자 메소드 */
	private static int[] getUserInput() {
		System.out.print("숫자를 입력해주세요 : ");
		String inputNum = Console.readLine();
		if (inputNum.length() != BALL_SIZE) {
			throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
		}
		int[] userBall = new int[BALL_SIZE];
		for (int i = 0; i < BALL_SIZE; i++) {
			userBall[i] = Character.getNumericValue(inputNum.charAt(i));
		}
		return userBall;
	}

	/* 오류를 체크하는 메소드*/
	private static void checkBall(int[] inputBalls) {
		Set<Integer> set = new HashSet<>();
		for (int num : inputBalls) {
			if (num < MIN || num > MAX) {
				throw new IllegalArgumentException("1~9의 범위 내에서 입력해주세요.");
			}
			if (!set.add(num)) {
				throw new IllegalArgumentException("숫자를 중복해서 입력하지 마세요.");
			}
		}
		System.out.println("오류 없음");
	}

	/* 볼 카운트 메소드 */
	private static int ballCheck(int[] computerNum, int[] userNum) {
		int ball = 0;
		for (int num : userNum) {
			if (contains(computerNum, num)) {
				ball++;
			}
		}
		return ball;
	}

	/* 스트라이크 카운트 메소드 */
	private static int strikeCheck(int[] computerNum, int[] userNum) {
		int strike = 0;
		for (int i = 0; i < BALL_SIZE; i++) {
			if (computerNum[i] == userNum[i]) {
				strike++;
			}
		}
		return strike;
	}

	/* 배열에 숫자가 포함되어 있는지 확인하는 메소드 */
	private static boolean contains(int[] array, int target) {
		for (int num : array) {
			if (num == target) {
				return true;
			}
		}
		return false;
	}
}
