package com.foxminded.foxstudent105614.charcounter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Logic{
    private final Map<String, Map<Character, Integer>> cache = new HashMap<>();
    private String text;

    public void processAndCacheText(String input) {
        if (!cache.containsKey(input)) {
            System.out.println("Adding to cache");
            Map<Character, Integer> charCountMap = calculateWord(input);
            addToCache(input, charCountMap);
            setText(input);
        } else {
            System.out.println("Already in cache");
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

    private Map<Character, Integer> calculateWord(String input) {
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

    public Optional<Map<Character, Integer>> getWordFromCache(String input) {
        return Optional.ofNullable(cache.get(input));
    }
}




