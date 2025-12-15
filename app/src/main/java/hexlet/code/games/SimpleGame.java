package hexlet.code.games;

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
    public String congratulations(String answerRequest) {
        return "Correct!";
    }

    @Override
    public String failure(String answerRequest) {
        return "'%s' is wrong answer ;(. Correct answer was '%s'.".formatted(answerRequest, quest.answer());
    }


    @Override
    public Quest currentQuest() {
        return quest;
    }

    @Override
    public int attempts() {
        return 3;
    }
}
