package baseball;
import static mallang.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }

    //메서드 선언

    public static int checkInputNum() throws IllegalArgumentException{
        int k = Integer.parseInt(readLine());
        if (!((1 <= k) & (k <= 9))) {
            throw new IllegalArgumentException();
        }
        return k;
    }
}
