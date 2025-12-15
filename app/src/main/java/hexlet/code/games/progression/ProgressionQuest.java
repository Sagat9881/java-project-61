package hexlet.code.games.progression;

import hexlet.code.games.Quest;

import java.util.Random;

public class ProgressionQuest extends Quest {
    private final static Random random = new Random();

    public ProgressionQuest(String[] series) {

        super.answer = maskValue(series, random.nextInt(0, series.length - 1));
        super.answerMatcher = (answer) -> answer.equals(this.answer);
        super.question = "What number is missing in the progression?\n Question: " + String.join(" ", series);
    }

    public ProgressionQuest() {
        this(generateSeries(random.nextInt(5, 10) ) );
    }

    private static String[] generateSeries(int length) {
        int incrementByStep = random.nextInt(1, 26);
        int init = random.nextInt(1, 26);
        String[] series = new String[length];
        for (int step = 0; step < length; step++) {
            series[step] = String.valueOf(init + step * incrementByStep);
        }
        return series;
    }

    private static String maskValue(String[] series, int index) {
        final String value = series[index];
        series[index] = "..";
        return value;
    }
}
