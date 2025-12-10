package hexlet.code.games;

import hexlet.code.games.quest.GCDQuest;
import hexlet.code.games.quest.Quest;

public class GCD implements Game {
    private GCDQuest quest;

    @Override
    public String name() {
        return "GCD";
    }

    @Override
    public String congratulations(String answer) {
        return "Correct!";
    }

    @Override
    public String failure(String answer) {
        return  "'%s' is wrong answer ;(. Correct answer was '%s'.".formatted(answer, quest.answer());
    }

    @Override
    public Quest generateQuest() {
        this.quest = new GCDQuest();
        return quest;
    }

    @Override
    public Quest currentQuest() {
        return quest;
    }
}
