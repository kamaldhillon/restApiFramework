package initializer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import reportmanagement.ExtentManager;

public class TestInit {
    private static ExtentReports extentReport;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        // Start the test for the Before Suite
       extentReport  = ExtentManager.getReportObject();

        if (extentReport == null) {
            throw new IllegalStateException("ExtentReport initialization failed in beforeSuite.");
        }
    }

    @AfterSuite
    public void afterSuite() {
        if (extentReport != null) {
            extentReport.flush();
        }
    }
}
