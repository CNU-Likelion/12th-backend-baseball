package baseball;

import java.util.ArrayList;
import java.util.List;
import mallang.missionutils.Randoms;

public class RandomAnswerGenerator implements AnswerGenerator {

    private static final int MAXIMUM_LENGTH_OF_ANSWER = 3;

    @Override
    public List<Integer> generate() {
        final List<Integer> answers = new ArrayList<>();
        while (answers.size() < MAXIMUM_LENGTH_OF_ANSWER) {
            final int randomDigit = Randoms.pickNumberInRange(1, 9);
            if (!answers.contains(randomDigit)) {
                answers.add(randomDigit);
            }
        }
        return answers;
    }
}
