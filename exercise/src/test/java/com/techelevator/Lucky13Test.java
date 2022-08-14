package com.techelevator;
import static org.junit.Assert.*;
import org.junit.Test;


public class Lucky13Test {

    Lucky13 lucky13 = new Lucky13();
    @Test

    public void test_024() {


        int[] nums = {0, 2, 4};
        assertEquals(true, lucky13.getLucky(nums));
    }
   @Test
   public void test_123() {
        int[] nums = {1,2,3};
        assertEquals(false, lucky13.getLucky(nums));
   }
   @Test
    public void test_124() {
        int[] nums = {1,2,4};
        assertEquals(false, lucky13.getLucky(nums));
   }
   @Test
    public void test_244() {
        int[] nums = {2,4,4};
        assertEquals(true, lucky13.getLucky(nums));
   }
    @Test
    public void test_for_333() {
        int[] nums = {3, 3, 3};
        assertEquals(false, lucky13.getLucky(nums));
    }

    @Test
    public void test_for_000() {
        int[] nums = {0, 0, 0};
        assertEquals(true, lucky13.getLucky(nums));
    }

}