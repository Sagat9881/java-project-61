package hexlet.code.games.quest;

import java.util.Random;

public class ProgressionQuest extends Quest {
    private final static Random random = new Random();
    private final String [] series;

    public ProgressionQuest(int length) {
        this.series = generateSeries(length);
        super.answer = maskValue(this.series, random.nextInt(0, this.series.length - 1));
        super.answerMatcher =(answer) -> answer.equals(this.answer);
        super.question = "What number is missing in the progression?\n Question: " + String.join(" ", this.series);
    }

    public ProgressionQuest() {
        this(random.nextInt(5, 10));
    }

    private static String[] generateSeries(int length){
        int incrementByStep = random.nextInt(1, 26);
        int init = random.nextInt(1, 26);
        String[] series = new String[length];
        for(int step = 0; step < length; step++){
            series[step] = String.valueOf(init + step * incrementByStep);
        }
        return series;
    }
    private static String maskValue( String[] series, int index){
        final String value = series[index];
        series[index] = "..";
        return value;
    }
}
