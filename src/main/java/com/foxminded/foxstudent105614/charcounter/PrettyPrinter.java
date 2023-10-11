package com.foxminded.foxstudent105614.charcounter;

import java.util.Map;

public class PrettyPrinter{
    private static final String NEW_LINE = System.lineSeparator();

    public String print(CharCounter charCounter) {
        String text = charCounter.getText();
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> charCountMap = charCounter.getUniqueCharacterCountsFromCache(text);

        result.append(text).append(NEW_LINE);

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            char character = entry.getKey();
            int count = entry.getValue();
            result.append(String.format("\"%c\" - %d", character, count)).append(NEW_LINE);
        }
        return result.toString();
    }
}