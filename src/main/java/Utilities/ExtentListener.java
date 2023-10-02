package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener implements ITestListener {

    ExtentSparkReporter reporter;
    ExtentReports reports;

    ExtentTest test;

    String filepath = "C:\\Users\\rajat\\IdeaProjects\\CapistoneProject\\Report\\extentReport.html";

    public ExtentListener(){
        reporter = new ExtentSparkReporter(filepath);
        reports = new ExtentReports();
    }
    public void configReport(){

        reports.attachReporter(reporter);
    }
    @Override
    public void onStart(ITestContext context){
        configReport();

    }
    @Override
    public void onFinish(ITestContext context){
        reports.flush();
        System.out.println("Extent Report is ready ");
    }
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Test Execution starts : "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        test = reports.createTest("@TestName is "+result.getName());
        test.log(Status.PASS,"Test passed is "+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result){
        test = reports.createTest("@Test is "+result.getName());
        test.log(Status.FAIL,"@Test failed is "+result.getName());
        test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\"+result.getName()+".png");
    }

    @Override
    public void onTestSkipped(ITestResult result){

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){


    }




}
