package baseball;
import mallang.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }
    // 1부터 9까지의 서로 다른 임의의 수를 3개 생성해서 배열에 저장
    public int[] answerNum() {
        int[] answer = new int[3];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = Randoms.pickNumberInRange(1,9);
        }
        return answer;
    }

}
