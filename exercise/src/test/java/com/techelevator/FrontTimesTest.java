package com.techelevator;
import static org.junit.Assert.*;

import org.junit.Test;
public class FrontTimesTest {

    @Test

    public void test_for_frontTimes() {
        FrontTimes frontTimes = new FrontTimes();
        assertEquals("ChoCho", frontTimes.generateString("Chocolate", 2) );
        assertEquals("ChoChoCho", frontTimes.generateString("Chocolate", 3));
        assertEquals("AbcAbcAbc", frontTimes.generateString("Abc", 3));
        assertEquals("", frontTimes.generateString("Chocolate", 0));
        assertEquals("", frontTimes.generateString(null, 3));



    }


}
