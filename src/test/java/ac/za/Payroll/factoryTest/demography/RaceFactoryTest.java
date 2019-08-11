package ac.za.Payroll.factoryTest.demography;

import ac.za.Payroll.factory.demography.RaceFactory;
import ac.za.Payroll.model.demography.Race;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RaceFactoryTest {
    private String testName;

    @Before
    public void setUp() throws Exception {
        this.testName = "testName";
    }

    @Test
    public void buildRace() {
        Race course = RaceFactory.buildRace(this.testName);
        Assert.assertNotNull(course.getRaceId());
        Assert.assertNotNull(course);
    }
}
