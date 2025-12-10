package hexlet.code.games;

import hexlet.code.games.quest.MathQuest;
import hexlet.code.games.quest.Quest;

public class Math implements Game{
    private MathQuest quest;
    @Override
    public String name() {
        return "Math";
    }

    @Override
    public String congratulations(String answer) {
        return "Correct!";
    }

    @Override
    public String failure(String answer) {
        return "'%s' is wrong answer ;(. Correct answer was '%s'.".formatted(answer, quest.answer());
    }

    @Override
    public Quest generateQuest() {
        this.quest = new MathQuest();
        return quest;
    }

    @Override
    public Quest currentQuest() {
        return quest;
    }
}
