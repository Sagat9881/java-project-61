package hexlet.code.games.quest;

import java.util.Random;

public class EvenQuest extends Quest {
    private final Random random = new Random();
    private final Integer value;

    public EvenQuest() {
        super();
        value = random.nextInt(0, 20);
        super.answer = value % 2 == 0 ? "y" : "n";
        super.question = String.join("\n", "%s - Is the number even? ".formatted(value), "Type 'y' for 'yes' or 'n' for 'no'");
    }

}
