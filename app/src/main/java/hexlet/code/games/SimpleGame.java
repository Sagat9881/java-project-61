package hexlet.code.games;

import hexlet.code.games.quest.Quest;

public abstract class SimpleGame implements Game {
    protected Quest quest;

    protected SimpleGame(Quest quest) {
        this.quest = quest;
    }

    @Override
    public String name() {
        return this.getClass().getSimpleName();
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
    public Quest currentQuest() {
        return quest;
    }
}
