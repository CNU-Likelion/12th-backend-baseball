package baseball;

public class Hint {

    private int strike = 0;
    private int ball = 0;

    public Hint() {
    }

    public void increaseStrike() {
        this.strike++;
    }

    public void increaseBall() {
        this.ball++;
    }

    public boolean isStrikeOut() {
        return strike == 3;
    }

    public void print() {
        final StringBuilder hintMessageBuilder = new StringBuilder();
        if (ball != 0) {
            hintMessageBuilder.append(ball).append("볼 ");
        }
        if (strike != 0) {
            hintMessageBuilder.append(strike).append("스트라이크");
        }
        if (ball == 0 && strike == 0) {
            hintMessageBuilder.append("낫싱");
        }
        System.out.println(hintMessageBuilder);
    }
}
