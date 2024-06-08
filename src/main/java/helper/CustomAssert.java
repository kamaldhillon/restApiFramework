package helper;

import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;
import reportmanagement.ExtentManager;

public class CustomAssert {
    static SoftAssert softAssert = new SoftAssert();

    public void setSoftAssert(SoftAssert softAssert) {
        this.softAssert = softAssert;
    }

    public static void assertEquals(int actual, int expected, String message) {
            try {
                softAssert.assertEquals(actual, expected, message);
                ExtentManager.getTest().log(Status.PASS, message);
            } catch (AssertionError e) {
                ExtentManager.getTest().log(Status.FAIL, message + ": " + e.getMessage());
                softAssert.fail(message + ": " + e.getMessage());
            }
    }

    public static void assertEquals(String actual, String expected, String message) {
        try {
            softAssert.assertEquals(actual, expected, message);
            ExtentManager.getTest().log(Status.PASS, message);
        } catch (AssertionError e) {
            ExtentManager.getTest().log(Status.FAIL, message + ": " + e.getMessage());
            softAssert.fail(message + ": " + e.getMessage());
        }
    }

    public static void assertTrue(boolean condition, String message) {
        try {
            softAssert.assertTrue(condition, message);
            ExtentManager.getTest().log(Status.PASS, message);
        } catch (AssertionError e) {
            ExtentManager.getTest().log(Status.FAIL, message + ": " + e.getMessage());
            softAssert.fail(message + ": " + e.getMessage());
        }
    }

    @AfterMethod
    public static void assertAll() {
        softAssert.assertAll();
    }
}
