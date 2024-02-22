package baseball;

import mallang.missionutils.Console;
import mallang.missionutils.Randoms;
import java.util.*;

public class Application {
	private static final int BALL_MIN = 1;
	private static final int BALL_MAX = 9;
	private static final int BALL_SIZE = 3;

	public static void main(String[] args) {
		boolean gameSignal = true;
		while (gameSignal) {
			gameSignal = playGame();
		}
	}

	private static boolean contains(int[] array, int target) {
		for (int num : array) {
			if (num == target) {
				return true;
			}
		}
		return false;
	}

	private static int ballCheck(int[] computerNum, List<String> userNum) {
		int ball = 0;
		for (int i = 0; i < BALL_SIZE; i++) {
			if (contains(computerNum, Integer.parseInt(userNum.get(i)))) {
				ball++;
			}
		}
		return ball;
	}

	private static int strikeCheck(int[] computerNum, List<String> userNum) {
		int strike = 0;
		for (int i = 0; i < BALL_SIZE; i++) {
			if (computerNum[i] == Integer.parseInt(userNum.get(i))) {
				strike++;
			}
		}
		return strike;
	}

	private static void hintBall(int strikeScore, int ballScore) {
		if (strikeScore != 0 && ballScore == 0) {
			System.out.println(strikeScore + "스트라이크");
		} else if (strikeScore == 0 && ballScore != 0) {
			System.out.println(ballScore + "볼");
		} else if (strikeScore == 3) {
			System.out.println(strikeScore + "스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		} else if (strikeScore == 0 && ballScore == 0) {
			System.out.println("낫싱");
		} else if (strikeScore != 0 && (ballScore - strikeScore) == 0) {
			System.out.println(strikeScore + "스트라이크");
		} else {
			System.out.println((ballScore - strikeScore) + "볼 " + strikeScore + "스트라이크");
		}
	}

	private static boolean checkError(List<String> inputBalls) {
		Set<Integer> set = new HashSet<>();
		try {
			if (inputBalls.size() != BALL_SIZE) {
				throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
			}
			for (String num : inputBalls) {
				int intNum = Integer.parseInt(num);
				if (intNum < BALL_MIN || intNum > BALL_MAX) {
					throw new IllegalArgumentException("1~9의 범위 내에서 입력해주세요.");
				}
				if (!set.add(intNum)) {
					throw new IllegalArgumentException("숫자를 중복해서 입력하지 마세요.");
				}
			}
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static int[] generateRandomBall() {
		Set<Integer> set = new HashSet<>();
		int[] randomBall = new int[3];
		int count = 0;
		while (count < 3) {
			int number = Randoms.pickNumberInRange(1, 9);
			if (!set.contains(number)) {
				randomBall[count] = number;
				set.add(number);
				count++;
			}
		}
		return randomBall;
	}

	private static List<String> getUserInput() {
		System.out.print("숫자를 입력해주세요 : ");
		List<String> inputBalls = new ArrayList<>();
		String inputNum = Console.readLine();
		for (char c : inputNum.toCharArray()) {
			inputBalls.add(Character.toString(c));
		}
		return inputBalls;
	}

	private static boolean playAgain() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String inputNum = Console.readLine();
		if (!inputNum.equals("1") && !inputNum.equals("2")) {
			System.out.println("올바른 입력이 아닙니다. 다시 시도하세요.");
			return inputNum.equals("2");
		}
		return inputNum.equals("1");
	}

	private static boolean playGame() {
		int computerBall[] = generateRandomBall();
		while (true) {
			List<String> userBall = getUserInput();
			if (!checkError(userBall)) {
				return false;
			}
			int ballScore = ballCheck(computerBall, userBall);
			int strikeScore = strikeCheck(computerBall, userBall);
			hintBall(strikeScore, ballScore);
			if (strikeScore == 3) {
				return playAgain();
			}
		}
	}
}