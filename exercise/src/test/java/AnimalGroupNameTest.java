import com.techelevator.AnimalGroupName;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalGroupNameTest {

    AnimalGroupName animalgroupName = new AnimalGroupName();

    @Test
    public void get_herds() {
        assertEquals( "Crash", animalgroupName.getHerd("rhino"));
        assertEquals("Tower", animalgroupName.getHerd("giraffe"));
        assertEquals("Herd", animalgroupName.getHerd("elephant"));
        assertEquals("Pride", animalgroupName.getHerd("lion"));
        assertEquals("Murder", animalgroupName.getHerd("crow"));
        assertEquals("Kit", animalgroupName.getHerd("pigeon"));
        assertEquals("Pat", animalgroupName.getHerd("flamingo"));
        assertEquals("Herd",animalgroupName.getHerd("deer"));
        assertEquals("Pack", animalgroupName.getHerd("dog"));
        assertEquals("Float", animalgroupName.getHerd("crocodile"));
    }
    @Test
    public void get_herds_Capitalized() {
        assertEquals( "Crash", animalgroupName.getHerd("Rhino"));
        assertEquals("Tower", animalgroupName.getHerd("Giraffe"));
        assertEquals("Herd", animalgroupName.getHerd("Elephant"));
        assertEquals("Pride", animalgroupName.getHerd("Lion"));
        assertEquals("Murder", animalgroupName.getHerd("Crow"));
        assertEquals("Kit", animalgroupName.getHerd("Pigeon"));
        assertEquals("Pat", animalgroupName.getHerd("Flamingo"));
        assertEquals("Herd",animalgroupName.getHerd("Deer"));
        assertEquals("Pack", animalgroupName.getHerd("Dog"));
        assertEquals("Float", animalgroupName.getHerd("Crocodile"));
    }
    @Test
    public void test_null() {
        assertEquals("unknown", animalgroupName.getHerd(null));
    }

    @Test
    public void test_for_unknown_animal() {
        assertEquals("unknown",animalgroupName.getHerd("Seal"));
    }
    @Test
    public void test_for_Empty() {
        assertEquals("unknown", animalgroupName.getHerd(""));
    }

    }

