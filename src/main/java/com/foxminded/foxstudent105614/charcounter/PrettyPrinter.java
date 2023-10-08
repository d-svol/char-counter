package com.foxminded.foxstudent105614.charcounter;

import java.util.Map;

public class PrettyPrinter implements DivideOperationPrinter{
    private static final String NEW_LINE = System.lineSeparator();

    @Override
    public String print(CharCounter charCounter) {
        StringBuilder result = new StringBuilder();
        String text = charCounter.getText();
        Map<Character, Integer> charCountMapOptional = charCounter.getUniqueCharacterCountsFromCache(text);

        result.append(text).append(NEW_LINE);

        for (Map.Entry<Character, Integer> entry : charCountMapOptional.entrySet()) {
            char character = entry.getKey();
            int count = entry.getValue();
            result.append(String.format("\"%c\" - %d", character, count)).append(NEW_LINE);
        }
        return result.toString();
    }
}