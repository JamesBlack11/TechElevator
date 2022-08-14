package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;
    private Timesheet testTimeSheet;


    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
        testTimeSheet = new Timesheet(6, 1, 1, LocalDate.now(), 3.25, true, "TestTimesheet 1");
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet timesheet = sut.getTimesheet(1);
        assertTimesheetsMatch("getTimesheet returned incorrect id", TIMESHEET_1, timesheet);
        timesheet = sut.getTimesheet(2);
        assertTimesheetsMatch("getTimesheet returned incorrect id", TIMESHEET_2, timesheet);
        timesheet = sut.getTimesheet(3);
        assertTimesheetsMatch("getTimesheet returned incorrect id", TIMESHEET_3, timesheet);
        timesheet = sut.getTimesheet(4);
        assertTimesheetsMatch("getTimesheet returned incorrect id", TIMESHEET_4, timesheet);

    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet timesheet = sut.getTimesheet(99);
        Assert.assertNull("message here",timesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheets = sut.getTimesheetsByEmployeeId(1);
        Assert.assertEquals(2, timesheets.size());
        assertTimesheetsMatch("Timesheets don't match", TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch("Timesheets don't match", TIMESHEET_2, timesheets.get(1));


        timesheets = sut.getTimesheetsByEmployeeId(2);
        Assert.assertEquals(2, timesheets.size());

        assertTimesheetsMatch("Timesheets don't match", TIMESHEET_4, timesheets.get(1));
        assertTimesheetsMatch("Timesheets don't match", TIMESHEET_3, timesheets.get(0));
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1);
        Assert.assertEquals(3, timesheets.size());
        assertTimesheetsMatch("Timesheets don't match", TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch("Timesheets don't match", TIMESHEET_3, timesheets.get(2));
        assertTimesheetsMatch("Timesheets don't match", TIMESHEET_2, timesheets.get(1));

        timesheets = sut.getTimesheetsByProjectId(2);
        Assert.assertEquals(1, timesheets.size());
        assertTimesheetsMatch("Timesheets don't match", TIMESHEET_4, timesheets.get(0));
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet createdTimesheet = sut.createTimesheet(testTimeSheet);
        Integer newId = createdTimesheet.getTimesheetId();

        Assert.assertTrue(newId > 0);

        testTimeSheet.setTimesheetId(newId);
        assertTimesheetsMatch("Timesheets don't match", testTimeSheet, createdTimesheet);


    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet createdTimesheets = sut.createTimesheet(testTimeSheet);

        Integer newId = createdTimesheets.getTimesheetId();
        Timesheet retrievedTimesheet = sut.getTimesheet(newId);

        assertTimesheetsMatch("My Message",createdTimesheets, retrievedTimesheet);

    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet timesheetToUpdate = sut.getTimesheet(1);


        timesheetToUpdate.setEmployeeId(2);
        timesheetToUpdate.setProjectId(2);
        timesheetToUpdate.setDateWorked(LocalDate.now());
        timesheetToUpdate.setHoursWorked(3.5);
        timesheetToUpdate.setBillable(false);
        timesheetToUpdate.setDescription("Timesheet 5");

        sut.updateTimesheet(timesheetToUpdate);

        Timesheet retrieveTimesheet = sut.getTimesheet(1);
        assertTimesheetsMatch("they match", timesheetToUpdate, retrieveTimesheet);
    }


    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(1);
        Timesheet retrieveTimesheet = sut.getTimesheet(1);
        Assert.assertNull(retrieveTimesheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        Timesheet timesheet = sut.getTimesheet(1);
        Double billableHours = timesheet.getHoursWorked();

        Assert.assertTrue("message here", billableHours == 1.0 );
    }

    private void assertTimesheetsMatch(String message, Timesheet expected, Timesheet actual) {
        Assert.assertEquals(message, expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(message, expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(message, expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(message, expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(message, expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(message, expected.isBillable(), actual.isBillable());
        Assert.assertEquals(message, expected.getDescription(), actual.getDescription());
    }

}
