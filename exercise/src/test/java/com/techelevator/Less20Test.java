package com.techelevator;
import static org.junit.Assert.*;
import org.junit.Test;
public class Less20Test {

    @Test

    public void Less20() {
        Less20 less20 = new Less20();

        assertEquals(true, less20.isLessThanMultipleOf20(18));
        assertEquals(true, less20.isLessThanMultipleOf20(19));
        assertEquals(false, less20.isLessThanMultipleOf20(20));
        assertEquals(true, less20.isLessThanMultipleOf20(38));
        assertEquals(true, less20.isLessThanMultipleOf20(39));
        assertEquals(false, less20.isLessThanMultipleOf20(40));
        assertEquals(false, less20.isLessThanMultipleOf20(0));


    }

    }

