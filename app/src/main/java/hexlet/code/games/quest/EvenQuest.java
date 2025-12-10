package hexlet.code.games.quest;

import java.util.Random;

public class EvenQuest extends Quest {
    private static final Random random = new Random();
    private final Integer value;

    public EvenQuest(int value) {
        super(String.join("\n", "%s - Is the number even? ".formatted(value),
              "Type 'y' for 'yes' or 'n' for 'no'"),value % 2 == 0 ? "y" : "n");
        this.value = value;
    }

    public EvenQuest() {
        this(random.nextInt(0, 20));
    }

}
