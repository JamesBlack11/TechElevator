package com.techelevator;

import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.Assert.*;

public class StringBitsTest {

    @Test
    public void getBits() {
        // arrange
        StringBits stringBits = new StringBits();

        //act

        //assert
        assertEquals("Hello", stringBits.getBits("Heeololeo"));
        assertEquals("Hlo", stringBits.getBits("Hello"));
        assertEquals("H", stringBits.getBits("Hi"));
    }
    @Test
    public void getBits_passNull() {
        // arrange
        StringBits stringBits = new StringBits();

        //act
        String result = stringBits.getBits(null);

        //assert
        assertEquals("", result);
    }
}