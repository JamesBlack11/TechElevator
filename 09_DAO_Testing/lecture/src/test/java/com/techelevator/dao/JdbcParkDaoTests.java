package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;
    private Park testPark;
    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
       testPark = new Park(0, "Test park", LocalDate.now(), 900, true);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park park = sut.getPark(1);
        assertParksMatch("getPark returned incorrect id", PARK_1, park);

        park = sut.getPark(2);
        assertParksMatch("getPark returned incorrect id", PARK_2, park);

        park = sut.getPark(3);
        assertParksMatch("getPark returned incorrect id", PARK_3, park);

    }

    @Test
    public void getPark_returns_null_when_id_not_found() {


    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> parks = sut.getParksByState("AA");
        Assert.assertEquals(2, parks.size());
        assertParksMatch("message here", PARK_1, parks.get(0));
        assertParksMatch("message here", PARK_3, parks.get(1));

        parks = sut.getParksByState("BB");
        Assert.assertEquals(1, parks.size());
        assertParksMatch("message here", PARK_2, parks.get(0));
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
       List<Park> parks = sut.getParksByState("XX");
       Assert.assertEquals(0, parks.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {

        Park createdPark = sut.createPark(testPark);
        Integer newId = createdPark.getParkId();

        Assert.assertTrue(newId > 0);

        testPark.setParkId(newId);
        assertParksMatch("parks don't match", testPark, createdPark);

    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Park parkToUpdate = sut.getPark(1);

        parkToUpdate.setParkName("Updated");
        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setArea(900);
        parkToUpdate.setHasCamping(false);
        sut.updatePark(parkToUpdate);

        Park retrievePark = sut.getPark(1);
        assertParksMatch("they match", parkToUpdate, retrievePark);
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        sut.deletePark(1);
        Park retrievePark = sut.getPark(1);
        Assert.assertNull(retrievePark);

        List<Park> parks = sut.getParksByState("AA");
        Assert.assertEquals(1, parks.size());
        assertParksMatch("they match", PARK_3, parks.get(0));
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        Assert.fail();
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        Assert.fail();
    }

    private void assertParksMatch(String message, Park expected, Park actual) {
        Assert.assertEquals(message, expected.getParkId(), actual.getParkId());
        Assert.assertEquals(message, expected.getParkName(), actual.getParkName());
        Assert.assertEquals(message, expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(message, expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(message, expected.getHasCamping(), actual.getHasCamping());
    }

}
