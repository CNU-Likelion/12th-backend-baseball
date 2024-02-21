package baseball;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
            ArrayList<Integer> comNum = setComputerNums();
            boolean goGame = true;
            while (goGame) {
                ArrayList<Integer> userNum = getThreeNums();
                ArrayList<Integer> strikeBallNum = countStrikeBall(userNum, comNum);
                int strike = strikeBallNum.get(0);
                int ball = strikeBallNum.get(1);

                goGame = printResult(strike, ball);
            }
            doGame = wantGameRestart();
        }
    }

    public static ArrayList<Integer> setComputerNums() {
        ArrayList<Integer> computerNums = new ArrayList<>();

        for (int i = 0 ; i < 3 ; i++) {
            computerNums.add(pickNumberInRange(1,9));
        }

        return computerNums;
    }

    public static ArrayList<Integer> getThreeNums() {
        ArrayList<Integer> userNums;
        String inputNum ;

        System.out.print("숫자를 입력해주세요 : ");
        inputNum = readLine();
        if (inputNum.length() > 3) {
            throw new IllegalArgumentException();
        }
        checkDiffNums(inputNum);
        userNums = detachNum(inputNum);

        return userNums;
    }

    public static ArrayList<Integer> countStrikeBall(ArrayList<Integer> user, ArrayList<Integer> com) {
        int strike =0;
        int ball=0;

        for (int i =0; i<3; i++) {
            if (user.get(i).equals(com.get(i))) {
                strike++;
            }
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                ball = addBall(user,com,ball,i,j) ;
            }
        }
        ArrayList<Integer> returnValues = new ArrayList<>();
        returnValues.add(strike);
        returnValues.add(ball);

        return returnValues;
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

        if (restart.length() != 1) {
            throw new IllegalArgumentException();
        }

        checkInputNum(restart,1,2);

        if (restart.equals("1")) {
            return true;
        } else if (restart.equals("2")) {
            return false;
        } else {
            return false;
        }
    }

    public static void checkDiffNums(String strNums) {
        boolean isContainNum;

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0 ; i< 3; i++) {
            int idx = Integer.parseInt(String.valueOf(strNums.charAt(i)));

            isContainNum = !(nums.contains(idx));
            if (isContainNum) {
                nums.add(idx);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static ArrayList<Integer> detachNum(String nums) {
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char num = nums.charAt(i);
            String strNum = String.valueOf(num);
            if (checkInputNum(strNum, 1, 9)) {
                numsList.add(Integer.parseInt(strNum));
            }
        }
        return numsList;
    }

    public static int addBall(ArrayList<Integer> user, ArrayList<Integer> com, int ball, int i ,int j ) {
        if ((i != j) && (user.get(i).equals(com.get(j)))) {
            ball++;
        }
        return ball;
    }

    public static boolean checkInputNum(String inputWords,int start,int end) throws IllegalArgumentException{
        try {
            int num = Integer.parseInt(inputWords) ;
            if ((start <= num) && (num <= end)) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            throw e;
        }
    }
}