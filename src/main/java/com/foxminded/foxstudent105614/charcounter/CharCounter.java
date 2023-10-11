package com.foxminded.foxstudent105614.charcounter;

import com.foxminded.foxstudent105614.charcounter.cache.Cache;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter {
    private final Cache<String, Map<Character, Integer>> cache = new Cache<>();
    private String text;

    public void processAndCacheText(String input) {
        if (!cache.containsKey(input)) {
            setText(input);
            Map<Character, Integer> charCountMap = calculateCharacterCounts(input);
            addToCache(input, charCountMap);
        }
    }

    public String getText() {
        return text;
    }

    private void setText(String text) {
        this.text = text;
    }

    private void addToCache(String key, Map<Character, Integer> value) {
        cache.put(key, value);
    }

    private Map<Character, Integer> calculateCharacterCounts(String input) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        return charCountMap;
    }

    public Map<Character, Integer> getUniqueCharacterCountsFromCache(String input) {
        return cache.get(input);
    }
}




