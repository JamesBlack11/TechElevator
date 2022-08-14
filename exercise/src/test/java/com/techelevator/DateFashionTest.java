package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.*;
public class DateFashionTest {
    DateFashion dateFashion = new DateFashion();

    @Test
    public void test_for_5_10() {
        assertEquals(2, dateFashion.getATable(5,10));
        assertEquals(0, dateFashion.getATable(5, 2));
        assertEquals(1, dateFashion.getATable(5,5));
        assertEquals(0, dateFashion.getATable(0,9));
    }
}
