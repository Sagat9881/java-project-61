package hexlet.code.games.even;

import hexlet.code.games.Quest;

import java.util.Random;

import static hexlet.code.engine.Engine.NO;
import static hexlet.code.engine.Engine.YES;


public class EvenQuest extends Quest {
    private static final Random random = new Random();

    public EvenQuest(int value) {
        super(
                String.join("\n",
                        "%s - Is the number even? ".formatted(value),
                        "Type %s for 'yes' or %s for 'no'".formatted(YES, NO)),

                value % 2 == 0 ? YES : NO);
    }

    public EvenQuest() {
        this(random.nextInt(0, 20));
    }

}
