package baseball;
import static mallang.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }

    //메서드 선언

    public static int checkInputNum() throws IllegalArgumentException{
        System.out.println("숫자를 입력해주세요 : ");

        int k = Integer.parseInt(readLine());
        if (!((1 <= k) & (k <= 9))) {
            throw new IllegalArgumentException();
        }
        return k;
    }

    public static int[] getThreeNums() {
        int[] userNums = new int[3];

        for (int i = 0 ; i<3 ; i++) {
            userNums[i]=checkInputNum();
        }

        return userNums;
    }
}
