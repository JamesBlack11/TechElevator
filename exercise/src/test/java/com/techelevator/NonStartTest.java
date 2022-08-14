package com.techelevator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NonStartTest {
    NonStart nonStart = new NonStart();

    @Test
    public void test_for() {
        assertEquals("ellohere", nonStart.getPartialString("Hello", "There"));
        assertEquals("avaode", nonStart.getPartialString("java", "code"));
        assertEquals("hotlava", nonStart.getPartialString("shotl", "java"));
        assertEquals("", nonStart.getPartialString("", ""));
        assertEquals("", nonStart.getPartialString(null, null));
    }

}
