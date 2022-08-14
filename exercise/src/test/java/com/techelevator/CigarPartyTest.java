package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

/*
When squirrels get together for a party, they like to have cigars. A squirrel party is successful
when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case
there is no upper bound on the number of cigars. Return true if the party with the given values is
successful, or false otherwise.
haveParty(30, false) → false
haveParty(50, false) → true
haveParty(70, true) → true
*/

public class CigarPartyTest {

    CigarParty cigarParty = new CigarParty(); // instantiate an object with the methods to test

    @Test
    public void test_for_cigars() {
        assertEquals( false, cigarParty.haveParty(30, false));
        assertEquals( true, cigarParty.haveParty(50, false));
        assertEquals( true, cigarParty.haveParty(70, true));
        assertEquals( false, cigarParty.haveParty(70, false));
        assertEquals( false, cigarParty.haveParty(0, false));
        assertEquals(false, cigarParty.haveParty(0, true));

    }



}