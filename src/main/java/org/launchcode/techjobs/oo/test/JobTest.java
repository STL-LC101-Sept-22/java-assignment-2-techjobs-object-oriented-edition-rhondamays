package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        String spec = "each job should have a unique id ";
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String spec = "the constructor sets the class and the value of each field";
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        String spec = "test equals method correctly sets equality to false";

        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        String spec = "when passed Job object, returned string should begin and end with new line character";
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(testJob.toString().charAt(0), '\n');
        assertEquals(testJob.toString().charAt(testJob.toString().length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String spec = "test toString() to ensure it contains correct labels and data";
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expected = '\n' +
                "ID: " + testJob.getId() +
                "\nName: " + testJob.getName() +
                "\nEmployer: " + testJob.getEmployer() +
                "\nLocation: " + testJob.getLocation() +
                "\nPosition Type: " + testJob.getPositionType() +
                "\nCore Competency: " + testJob.getCoreCompetency() + '\n';

        String actual = testJob.toString() ;
        assertEquals(expected, actual);

    }

    @Test
    public void testToStringHandlesEmptyField() {
        String spec = "toString() should return 'Data not available' if field is empty";

        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));

        String expected = '\n' +
                "ID: " + testJob.getId() +
                "\nName: " + testJob.getName() +
                "\nEmployer: " + "Data not available" +
                "\nLocation: " + testJob.getLocation() +
                "\nPosition Type: " + "Data not available" +
                "\nCore Competency: " + testJob.getCoreCompetency() + '\n';

        String actual = testJob.toString();
        assertEquals(expected, actual);

    }

}
