package TestCasePackage;

import Utilities.ReadConfigFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class BaseClass {

    WebDriver driver;

    String Extentpath = System.getProperty("user.dir")+"\\Report\\newExtentReport.html";

    ExtentSparkReporter reporter = new ExtentSparkReporter(Extentpath);
    ExtentReports reports = new ExtentReports();
    ExtentTest test ;


    ReadConfigFile readConfigFile = new ReadConfigFile();

    String url = readConfigFile.getUrl();
    String browser = readConfigFile.getBrowser();

    Logger log;

    @BeforeTest
    public void extent(){
        reports.attachReporter(reporter);
    }

    @BeforeClass
    public void setup(){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println(" Chromedriver is all set to launch");
        } else if (browser.equalsIgnoreCase("ms edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println(" msEdge is all set to launch");

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println(" Firefox driver is all set to launch");

        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            System.out.println("Safari driver is all set to launch");

        }
        else{
            System.out.println("No driver is there to launch, ERROR");
        }

        log = LogManager.getLogger("CapistoneProject");
    }



    @AfterClass
    public void tearDown(){

        driver.quit();
    }

    public void captureScreenShot(String testName){

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.dir")+"\\ScreenShots\\"+testName+".png");
        try {
            FileHandler.copy(srcFile, destFile);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
    @AfterTest
    public void printExtentReport(){
        reports.flush();
        log.info("extent report would be ready");


    }


}
