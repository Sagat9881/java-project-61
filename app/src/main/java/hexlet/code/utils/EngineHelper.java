package hexlet.code.utils;

import hexlet.code.games.Game;

import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class EngineHelper {
    private EngineHelper() {}

    public static HashMap<String, Game> buildGamesMap(List<Game> games) {
        return new HashMap<>( // avoid immutable
                IntStream.range(0, games.size()).boxed()
                        .collect(toMap(i -> String.valueOf(i + 2), games::get)));
    }


}
