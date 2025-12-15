package hexlet.code.games.even;

import hexlet.code.games.Quest;

import java.util.Random;

public class EvenQuest extends Quest {
    private static final Random random = new Random();

    public EvenQuest(int value) {
        super(
                String.join("\n",
                        "%s - Is the number even? ".formatted(value),
                        "Type 'y' for 'yes' or 'n' for 'no'"),

                value % 2 == 0 ? "y" : "n");
    }

    public EvenQuest() {
        this(random.nextInt(0, 20));
    }

}
