package baseball;

import baseball.domain.GenerateRandomNum;
import baseball.domain.Input;
import baseball.domain.Judge;
import baseball.domain.Playagain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        GenerateRandomNum randomNum = new GenerateRandomNum();
        Input input = new Input();
        Judge judge = new Judge();
        Playagain playagain = new Playagain();
        boolean again = true;

        while (again) {
            List<Integer> computer = randomNum.create();
            String result = "";
            while (!result.equals("3스트라이크")) {
                result = judge.judgement(computer, input.playerNumber());
                System.out.println(result);
            }
            again = playagain.playagain();

        }
    }
}

