package com.foxminded.foxstudent105614.charcounter;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {
    @Test
    void testProcessAndCacheText_shouldByNotEquals_whenAlreadyInCache() {
        CharCounter charCounter = new CharCounter();
        String input1 = "Hello";
        String input2 = "hello";
        charCounter.processAndCacheText(input1);
        charCounter.processAndCacheText(input2);

        Map<Character, Integer>result1 = charCounter.getUniqueCharacterCountsFromCache(input1);
        Map<Character, Integer> result2 = charCounter.getUniqueCharacterCountsFromCache(input2);

        assertNotEquals(result1, result2);
    }

    @Test
    void testProcessAndCacheText_AlreadyInCache() {
        CharCounter charCounter = new CharCounter();
        String input = "world";
        charCounter.processAndCacheText(input);
        charCounter.processAndCacheText(input);

        Map<Character, Integer> result = charCounter.getUniqueCharacterCountsFromCache(input);
        assertNotNull(result);
        assertEquals(5, result.size());
    }

    @Test
    void testProcessAndCacheText_shouldByEquals_whenSameWords() {
        CharCounter charCounter = new CharCounter();
        String input1 = "Hello";
        String input2 = "Hello";
        charCounter.processAndCacheText(input1);
        charCounter.processAndCacheText(input2);

        Map<Character, Integer>result1 = charCounter.getUniqueCharacterCountsFromCache(input1);
        Map<Character, Integer> result2 = charCounter.getUniqueCharacterCountsFromCache(input2);

        assertEquals(result1, result2);
    }

    @Test
     void testCalculateCharacterCounts() {
        CharCounter charCounter = new CharCounter();
        String input = "hello";

        charCounter.processAndCacheText(input);
        Map<Character, Integer> charCountMap = charCounter.getUniqueCharacterCountsFromCache(input);

        assertEquals(4, charCountMap.size());
        assertEquals(1, charCountMap.get('h'));
        assertEquals(1, charCountMap.get('e'));
        assertEquals(2, charCountMap.get('l'));
        assertEquals(1, charCountMap.get('o'));
    }
}