package hexlet.code.games.quest;

import java.util.Random;
import java.util.function.BiFunction;

public class MathQuest extends Quest {
    private static final Random r = new Random();
    private final int left;
    private final int right;
    private final Operation o;

    public MathQuest(int left, int right, Operation o) {
        this.left = left;
        this.right = right;
        this.o = o;
        super.answerMatcher = (answer) -> o.apply(left, right) == Integer.parseInt(answer);
        super.question = String.format("%d %s %d = ?", left, o.toString(), right);
        super.answer = String.valueOf(o.apply(left, right));
    }

    public MathQuest() {
         this( r.nextInt(100),
               r.nextInt(100),
               Operation.values()[r.nextInt(0, Operation.values().length)]
         );
    }

    public enum Operation {
        ADDITION(Integer::sum) {
            @Override
            public String toString() {
                return "+";
            }
        },
        SUBTRACTION((l, r) -> l - r) {
            @Override
            public String toString() {
                return "-";
            }
        },
        MULTIPLICATION((l, r) -> l * r) {
            @Override
            public String toString() {
                return "*";
            }
        };

        private final BiFunction<Integer, Integer, Integer> function;
        Operation(BiFunction<Integer, Integer, Integer> function) {
            this.function = function;
        }

        public int apply(int left, int right) {
            return function.apply(left, right);
        }
    }
}
