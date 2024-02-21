package baseball;
import static mallang.missionutils.Console.*;
import static mallang.missionutils.Randoms.*;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        startBallGame();
    }

    Application(){

    }

    public static void startBallGame(){
        boolean doGame = true;

        while (doGame) {
            int[] comNum = setComputerNums();
            boolean goGame = true;
            while (goGame) {
                int[] userNum = getThreeNums();
                int[] strikeBallNum = countStrikeBall(userNum, comNum);
                int strike = strikeBallNum[0];
                int ball = strikeBallNum[1];

                goGame = printResult(strike, ball);
            }
            doGame = wantGameRestart();
        }
    }

    //메서드 선언
    public static int[] setComputerNums() {
        int[] computerNums = new int[3];

        for (int i = 0 ; i < 3 ; i++) {
            computerNums[i] = pickNumberInRange(1,9);
        }

        return computerNums;
    }

    public static int[] getThreeNums() {
        int[] userNums;
        String k ;

        System.out.print("숫자를 입력해주세요 : ");
        k = readLine();
        if (k.length() > 3) {
            throw new IllegalArgumentException();
        }
        checkdiffNums(k);
        userNums = detachNum(k);

        return userNums;
    }

    public static int[] countStrikeBall(int[] user, int[] com) {
        int strike =0;
        int ball=0;

        for (int i =0; i<3; i++) {
            if(user[i] == com[i]) {
                strike++;
            }
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                ball = addBall(user,com,ball,i,j) ;
            }
        }
        return new int[] {strike,ball};
    }

    public static boolean printResult(int strike, int ball){
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }else if ((strike != 0) && (ball != 0)) {
            System.out.printf("%d볼 %d스트라이크\n",ball,strike);
            return true;
        } else if (strike != 0) {
            System.out.printf("%d스트라이크\n",strike);
            return true;
        } else if (ball != 0) {
            System.out.printf("%d볼\n", ball);
            return true;
        } else {
            System.out.println("낫싱");
            return true;
        }
    }

    public static boolean wantGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = readLine();

        //입력값 유효성 체크
        //한글자 숫자인지 먼저 확인
        if (restart.length() != 1) {

        }
        //숫자값이 1 또는 2인지 확인
        checkInputNum(restart,1,2);

        if (restart.equals("1")) {
            return true;
        } else if (restart.equals("2")) {
            return false;
        } else {
            return false;
        }
    }

    public static void checkdiffNums(String k) {
        int[] nums = new int[10];
        for (int i = 0 ; i< 3; i++) {
            int a = Integer.parseInt(String.valueOf(k.charAt(i)));
            if (nums[a] == 0) {
                nums[a] = a;
            } else {
                throw new IllegalArgumentException();
            }

        }
    }

    public static int[] detachNum(String k) {
        int[] numsList = new int[3];
        for (int i = 0; i < 3; i++) {
            char b = k.charAt(i);
            String a = String.valueOf(b);
            if (checkInputNum(a, 1, 9)) {
                numsList[i] = Integer.parseInt(a);
            }

        }
        return numsList;
    }

    public static int addBall(int[] user, int[] com, int ball, int i ,int j ) {
        if ((i != j) && (user[i] == com[j])) {
            ball++;
        }
        return ball;
    }

    public static boolean checkInputNum(String a,int start,int end) throws IllegalArgumentException{

        try {
            int b = Integer.parseInt(a) ;
            if ((start <= b) && (b <=end)) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            throw e;
        }

    }












}