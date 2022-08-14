package com.techelevator;
import static org.junit.Assert.*;
import org.junit.Test;


public class MaxEnd3Test {

    MaxEnd3 maxEnd3 = new MaxEnd3();
    private void assertEqualsArray(int[] correctArray, int[] makeArray) {

    }

    @Test
public void test123() {
        int[] correctArray = {3,3,3};
        int[] nums = {1,2,3};
        assertEqualsArray(correctArray, maxEnd3.makeArray(nums));
    }
@Test
    public void test1159() {
        int[] correctArray = {11,11,11};
        int[] nums = {11,5,9};
        assertEqualsArray(correctArray,maxEnd3.makeArray(nums));
    }
    @Test
    public void test2113() {
        int[] correctArray = {3,3,3};
        int[] nums = {2,11,3};
        assertEqualsArray(correctArray, maxEnd3.makeArray(nums));
    }
    @Test
    public void test000() {
        int[] correctArray = {0,0,0};
        int[] nums = {0,0,0};
        assertEqualsArray(correctArray, maxEnd3.makeArray(nums));
    }
}