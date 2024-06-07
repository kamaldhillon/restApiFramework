package listeners;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reportmanagement.ExtentManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static reportmanagement.ExtentManager.getTest;

public class TestNGListener implements ITestListener {

    private List<String> reportEntries;

    @Override
    public void onStart(ITestContext context) {

        System.out.println("onStart: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod() + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod() + " test has passed.");
        getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod() + " test has failed.");
        getTest().log(Status.FAIL, "Test Failed");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish: " + context.getName());
        // Do tear down operations for ExtentReports reporting
        ExtentManager.getReportObject().flush();
    }
}
