package baseball;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;





public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int userNumber[] = getInput(sc);
        int randomNumber[] = getRandomNumber();

        System.out.println("시작(1)/종료(2)");
        String start = sc.nextLine();



        while (true) {


            int strike = strike(userNumber, randomNumber);
            int ball = ball(userNumber, randomNumber);

            if(strike==3){
                System.out.println("3 스트라이크 정답 !!!");
                System.out.println("시작(1)/종료(2)");
                start = sc.nextLine();
                if(start=="2"){
                    break;
                }

            }

            else{
                System.out.println(strike+" 스트라이크 "+ball+" 볼");
            }


        }
        sc.close();
    }
    //랜덤 수 생성
    public static int[] getRandomNumber () {
        Random random = new Random();
        int[] randomNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            randomNumber[i] = (int) (Math.random() * 9) + 1;
        }
        return randomNumber;
    }
    //사용자 수 입력
    public static int[] getInput(Scanner sc) {

        int[] userNumber = new int[3];
        System.out.println();
        String input = sc.nextLine();
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            userNumber[i] = input.charAt(i);
        }

        return userNumber;

    }
    //스트라이크 수 계산
    public static int strike (int[] userNumber, int[] randomNumber){
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber[i] == randomNumber[i]) strike++;

        }
        return strike;
    }

    //볼 수 계산
    public static int ball (int[] userNumber, int[] randomNumber){
        int ball =0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(userNumber[i]==randomNumber[j]) ball++;
            }
        }
        return ball;
    }



}



