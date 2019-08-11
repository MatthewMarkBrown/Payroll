package ac.za.Payroll.factoryTest.demography;
import ac.za.Payroll.factory.demography.GenderFactory;
import ac.za.Payroll.model.demography.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GenderFactoryTest {
        private String testName;

        @Before
        public void setUp() throws Exception {
            this.testName = "testName";
        }

        @Test
        public void buildGender() {
            Gender course = GenderFactory.buildGender(this.testName);
            Assert.assertNotNull(course.getGenderId());
            Assert.assertNotNull(course);
        }
  }

