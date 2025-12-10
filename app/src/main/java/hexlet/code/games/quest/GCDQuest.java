package hexlet.code.games.quest;

import java.util.Random;

public class GCDQuest extends Quest {
    private final int left;
    private final int right;
    private final static Random random = new Random();

    public GCDQuest() {
        this.left = random.nextInt(100);
        this.right = random.nextInt(100);;
        super.answerMatcher = (answer) -> Integer.parseInt(answer) == gcd(left, right);
        super.question = "Find the greatest common divisor of given numbers: %d and %d".formatted(left, right);
        super.answer = String.valueOf(gcd(left, right));
    }


   private static int gcd(int a, int b) {
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
