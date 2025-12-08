package hexlet.code.games.quest;

import java.util.function.Predicate;

public abstract class Quest {
    protected String question;
    protected String answer;
    protected Predicate<String> answerMatcher;

    protected Quest(String question, String answer, Predicate<String> answerMatcher) {
        this.question = question;
        this.answer = answer;
        this.answerMatcher = answerMatcher;
    }

    protected Quest(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.answerMatcher = answer::equals;
    }

    protected Quest() {
        this.answerMatcher = answer != null ? answer::equals : (s) -> true;
    }

    protected Quest(Predicate<String> answerMatcher) {
        this.answerMatcher = answerMatcher;
    }

    public Predicate<String> matcher() {
        return answerMatcher;
    }

    public String answer() {
        return "Right answer is: %s".formatted(answer);
    }

    public String question() {
        return question;
    }
}
