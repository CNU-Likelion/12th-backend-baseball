package baseball;
import static mallang.missionutils.Console.*;
import static mallang.missionutils.Randoms.*;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }

    //메서드 선언

    public static boolean checkInputNum(char a) throws IllegalArgumentException{

        try {
            int b = (int) a ;
            if ((1 <= b) && (b <=9)) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            throw e;
        }

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
            if (checkInputNum(a)) {
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


    public static int[] countStrikeBall(int[] user, int[] com) {
        int strike =0;
        int ball=0;

        //스트라이크 찾기
        for (int i =0; i<3; i++) {

        }

        //볼찾기 (자리는 다른 같은 수 개수)
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if ((i!=j)&&(user[i] == com[i])) {
                    ball++;
                }
            }
        }

        return new int[] {strike,ball};
    }
}
