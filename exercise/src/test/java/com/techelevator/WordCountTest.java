package com.techelevator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    WordCount wordCount = new WordCount();

    @Test
    public void testblacksheep() {
        Map<String, Integer> output = new HashMap<String, Integer>();
        output.put("ba", 2);
        output.put("black", 1);
        output.put("sheep", 1);
        String[] test = {"ba", "ba", "black", "sheep"};
        assertEquals(output, wordCount.getCount(test));
    }

    @Test
    public void testabc() {
        Map<String, Integer> output = new HashMap<String, Integer>();
        output.put("a", 2);
        output.put("b", 2);
        output.put("c", 1);
        String[] test = {"a", "b", "a", "c", "b"};
        assertEquals(output, wordCount.getCount(test));
    }

    @Test
    public void testempty() {
        Map<String, Integer> output = new HashMap<String, Integer>();
        String[] test = {};
        assertEquals(output, wordCount.getCount(test));
    }

    @Test
    public void testcba() {
        Map<String, Integer> output = new HashMap<String, Integer>();
        output.put("c", 1);
        output.put("b", 1);
        output.put("a", 1);
        String[] test = {"c", "b", "a"};
        assertEquals(output, wordCount.getCount(test));
    }

    @Test
    public void testsleepy() {
        Map<String, Integer> output = new HashMap<String, Integer>();
        output.put("z", 20);
        String[] test = {"z", "z", "z","z", "z", "z","z", "z", "z","z", "z", "z","z", "z", "z","z", "z", "z","z", "z"};
        assertEquals(output, wordCount.getCount(test));
    }

}
