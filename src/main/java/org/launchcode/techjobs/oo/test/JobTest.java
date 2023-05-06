package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
       Job job1 = new Job();
       Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job tester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(tester.getName(),"Product tester");
        assertEquals(tester.getEmployer().toString(),"ACME");
        assertEquals(tester.getLocation().toString(),"Desert");
        assertEquals(tester.getPositionType().toString(),"Quality control");
        assertEquals(tester.getCoreCompetency().toString(),"Persistence");

        assertTrue(tester.getName().equals("Product tester"));
        assertTrue(tester.getEmployer() instanceof Employer);
        assertTrue(tester.getLocation() instanceof Location);
        assertTrue(tester.getPositionType() instanceof PositionType);
        assertTrue(tester.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job tester1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job tester2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(tester1.getId(),tester2.getId());
        assertFalse(tester1.equals(tester2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job tester3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testerString = tester3.toString();
        char firstChar = testerString.charAt(0);
        char lastChar = testerString.charAt(testerString.length()-1);

        assertEquals(lastChar, '\n');
        assertEquals(firstChar, '\n');

    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job tester8 = new Job("Product tester",
                new Employer(""),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        assertEquals(tester8.toString(), "\n" +
                "ID: " + tester8.getId() + "\n" +
                "Name: " + tester8.getName() + "\n" +
                "Employer: " + tester8.getEmployer() + "\n" +
                "Location: " + tester8.getLocation() + "\n" +
                "Position Type: " + tester8.getPositionType() + "\n" +
                "Core Competency: " + tester8.getCoreCompetency() + "\n");

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job tester7 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        tester7.toString();
        assertEquals(tester7.getEmployer().toString(), "Data Not Available");
    }
}
