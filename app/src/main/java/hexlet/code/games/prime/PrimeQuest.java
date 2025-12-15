package hexlet.code.games.prime;

import hexlet.code.games.Quest;

import java.util.Random;

import static hexlet.code.engine.Engine.NO;
import static hexlet.code.engine.Engine.YES;

public class PrimeQuest extends Quest {
    private static final Random r = new Random();

    public PrimeQuest(int n) {
        super(
                String.join("\n",
                        "%d - Is the number prime?".formatted(n),
                        "Type %s for 'yes' or %s for 'no'".formatted(YES, NO)),
                isPrime(n));
    }

    public PrimeQuest() {
        this(r.nextInt(100));
    }

    private static String isPrime(int n) {
        if (n == 1) return NO;
        if (n == 2) return YES;
        if (n % 2 == 0) return NO;
        int sqrt = (int) Math.sqrt(n);
        int i = Math.max(sqrt, 3);
        for (; i <= sqrt; i += 2) {
            if (n % i == 0) return NO;
        }
        return YES;
    }
}
