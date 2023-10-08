package com.foxminded.foxstudent105614.charcounter;

import java.util.Map;
import java.util.Optional;

public class PrettyPrinter implements DivideOperationPrinter{
    private static final String NEW_LINE = System.lineSeparator();

    @Override
    public String print(Logic logic) {
        String text = logic.getText();
        Optional<Map<Character, Integer>> charCountMapOptional = logic.getWordFromCache(text);

        if (charCountMapOptional.isPresent()) {
            Map<Character, Integer> charCountMap = charCountMapOptional.get();
            StringBuilder result = new StringBuilder();
            result.append(text).append(NEW_LINE);

            for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
                char character = entry.getKey();
                int count = entry.getValue();
                result.append(String.format("\"%c\" - %d", character, count)).append(NEW_LINE);
            }
            return result.toString();
        } else {
            return "Кеш не містить результатів для даного тексту.";
        }
    }
}