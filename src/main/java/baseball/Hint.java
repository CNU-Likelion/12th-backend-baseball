package baseball;

public class Hint {
    public static final int YES = 1;
    public static final int NO = 0;

    public int printAnswer(int numberOfStrike, int numberOfBall) {
        int ContinueUserSet = YES;

        if (numberOfBall != 0) {
            System.out.printf("%d볼 ", numberOfBall);
        }
        if (numberOfStrike != 0) {
            System.out.printf("%d스트라이크", numberOfStrike);
            if (numberOfStrike == 3)
                ContinueUserSet = NO;
        }
        if (numberOfBall == 0 && numberOfStrike == 0) {
            System.out.printf("낫싱");
        }
        System.out.println();

        return ContinueUserSet;
    }
}
