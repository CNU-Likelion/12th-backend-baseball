package baseball;
import static mallang.missionutils.Console.*;
import static mallang.missionutils.Randoms.*;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }

    //메서드 선언

    public static int checkInputNum() throws IllegalArgumentException{
        System.out.println("숫자를 입력해주세요 : ");

        if (!((1 <= k) & (k <= 9))) {
            throw new IllegalArgumentException();
        }
        return k;
    }

    //이용자로부터 숫자 3개를 받아 저장하는 함수
    public static int[] getThreeNums() {
        int[] userNums = new int[3];
        String k ;

        System.out.println("숫자를 입력해주세요 : ");
        k = readLine();

        //숫자로 분리하기
        for (int i =0 ; i<3 ; i++) {
            char a = k.charAt(i);
            if checkInputNum(a) {
                userNums[i] = (int) a;
            }
        }

        return userNums;
    }

    public static int[] setComputerNums() {
        int[] computerNums = new int[3];

        for (int i = 0 ; i < 3 ; i++) {
            computerNums[i] = pickNumberInRange(1,9);
        }

        return computerNums;
    }
}
