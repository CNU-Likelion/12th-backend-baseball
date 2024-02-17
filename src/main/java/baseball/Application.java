package baseball;
import static mallang.missionutils.Console.*;
import static mallang.missionutils.Randoms.*;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        startBallGame();
    }

    public static void startBallGame(){
        boolean doGame = true;

        while (doGame) {
            int[] userNum = getThreeNums();
            int[] comNum = setComputerNums();
            int[] strikeBallNum = countStrikeBall(userNum,comNum);
            int strike = strikeBallNum[0];
            int ball = strikeBallNum[1];

            doGame = printResult(strike,ball);
        }
    }

    //메서드 선언

    public static boolean checkInputNum(char a,int start,int end) throws IllegalArgumentException{

        try {
            int b = (int) a ;
            if ((start <= b) && (b <=end)) {
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
            if (checkInputNum(a,1,9)) {
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
            if(user[i] == com[i]) {
                strike++;
            }
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

    public static boolean printResult(int strike, int ball){
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return wantGameRestart();
        } else if ((strike != 0) & (ball != 0)) {
            System.out.printf("%d볼 %d스트라이크\n",strike,ball);
            return true;
        } else if (strike != 0) {
            System.out.printf("%d스트라이크\n",strike);
            return true;
        } else if (ball != 0) {
            System.out.printf("%d볼\n", ball);
            return true;
        } else {
            return true;
        }
    }

    public static boolean wantGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = readLine();

        //입력값 유효성 체크
        //한글자 숫자인지 먼저 확인
        if (restart.length() != 1) {
            throw new IllegalArgumentException();
        }
        //숫자값이 1 또는 2인지 확인
        checkInputNum(restart.charAt(0),1,2);

        if (restart.equals("1")) {
            return true;
        } else if (restart.equals("2")) {
            return false;
        } else {
            return false;
        }
    }
}
