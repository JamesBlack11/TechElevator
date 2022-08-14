package com.techelevator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SameFirstLastTest {

    SameFirstLast sameFirstLast = new SameFirstLast();

    @Test
    public void test123() {
        int[] nums = {1,2,3};
        assertEquals(false, sameFirstLast.isItTheSame(nums));
    }
    @Test
    public void test1231() {
        int[] nums = {1,2,3,1};
        assertEquals(true, sameFirstLast.isItTheSame(nums));
    }
    @Test
    public void test121() {
        int[] nums = {1,2,1};
        assertEquals(true, sameFirstLast.isItTheSame(nums));
    }
    @Test
    public void test100() {
        int[] nums = {1,0,0};
        assertEquals(false,sameFirstLast.isItTheSame(nums));
    }
    @Test
    public void test000() {
        int[] nums = {0,0,0};
        assertEquals(true, sameFirstLast.isItTheSame(nums));
    }
}
