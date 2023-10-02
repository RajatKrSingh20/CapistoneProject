package TestCasePackage;

import PageObjectPackage.*;
import Utilities.ExtentListener;
import Utilities.ReadExcelFile;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners(ExtentListener.class)

public class TestClass_01 extends BaseClass {

    String expectedCategory1;
    String actualCategory1;

    String actualProduct;
    String actualPrice;

    String expecProduct ;
    double expecPrice ;
    String finalExpectedPrice;

    @BeforeMethod
    public void launch(){
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Launched website and waited using implicitWait");
    }

    @Test(description = "This test verifies validation message displayed when user login with blank username and password",priority = 1,enabled = false)
    public void verifyValidationMessage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLogin();
        loginPage.clickOnSubmit();
       boolean result = loginPage.validateMessage();
       if(result == true){
           Assert.assertTrue(true);
           log.info("Validation message is displayed when username and password is left blank");
       }
       else{
           log.info("Validation message is not displayed when username and password is left blank");
           captureScreenShot("verifyValidationMessage");
           log.info("Screenshot is captured");
           Assert.assertTrue(false);
       }
    }

    @Test(description = "This test verifies that user can login and logout with valid credentials",priority = 2, enabled = false,dataProvider = "getData")
    public void verifyLoginAndLogout(String username, String password){
        LoginPage page = new LoginPage(driver);
        HomePage page2 = new HomePage(driver);

        page.clickOnLogin();
        log.info("clicked on login button");
        page.enterUserName(username);
        log.info("Entered username");
        page.enterPassword(password);
        log.info("Entered Password");
        page.clickOnSubmit();
        log.info("Clicked on submit button");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        String text = page2.verifyID();
        log.info("ID shown on top "+text);
        page2.clickOnLogout();
        log.info("clicked on logout button");

    }

    @Test(description = "This test is to verify, user can search for a product and validate price of different commodities",priority=1,enabled = true,dataProvider = "getData")
    public void verifySearch(String username, String password){
        test = reports.createTest("verifySearch");


        LoginPage page = new LoginPage(driver);
        ShoppingPage page2 = new ShoppingPage(driver);
        ReadExcelFile readExcelFile = new ReadExcelFile();
        HomePage page3 = new HomePage(driver);
        KitchenItemsPage page4 = new KitchenItemsPage(driver);

        String path = "C:\\Users\\rajat\\IdeaProjects\\CapistoneProject\\TestData\\TestData2.xlsx";


        page.clickOnLogin();
        log.info("Clicked on loginButton");
        page.enterUserName(username);
        log.info("Entered username");
        page.enterPassword(password);
        log.info("Entered Password");
        page.clickOnSubmit();
        log.info("Clicked on submit button");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        page2.clickOnElectronics();
        log.info("searched for electronics");


         actualCategory1 = "Electronics";

         expectedCategory1 = readExcelFile.getExcelDataString(path,"Sheet1",1,0);

         if(actualCategory1.equalsIgnoreCase(expectedCategory1)){
             log.info("Category matched is "+actualCategory1);
             Assert.assertTrue(true);

         }
         else {
             log.info("Category doesn't match /n expected category : "+expectedCategory1+"/n"+"actual category "+actualCategory1);
             captureScreenShot("verifySearch");
             Assert.assertTrue(false);
         }

         driver.navigate().back();
         log.info("clicked on back button");
         test.log(Status.INFO,"hello honey");


         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         page4.clickOnKitchenItems();
         log.info("clicked on kitchen items");
          actualProduct =  page4.getProductText();
          actualPrice   =  page4.getPrice();
          log.info("actualProduct "+actualProduct);
          log.info("actualPrice "+actualPrice);
          expecProduct = readExcelFile.getExcelDataString(path,"Sheet1",2,1);
          expecPrice = readExcelFile.getExcelDataNumeric(path,"Sheet1",2,2);
          finalExpectedPrice = String.valueOf(expecPrice);
          if(actualPrice.equalsIgnoreCase(finalExpectedPrice)){
              System.out.println("matched");
          }
          else{
              System.out.println("doesnt match"+finalExpectedPrice.getClass().getSimpleName()+" "+finalExpectedPrice);
              System.out.println("actualPrice "+actualPrice.getClass().getSimpleName()+" "+actualPrice);


          }
         if(actualProduct.equalsIgnoreCase(expecProduct)){
            log.info("product name matches "+expecProduct );
            Assert.assertTrue(true);
            driver.navigate().back();
             page3.clickOnLogout();
             log.info("logged-out");
         }
         else {
             log.info("product name doesn't match");
             captureScreenShot("verifySearch");
             Assert.assertTrue(false);
         }



    }
    @DataProvider
    public Object[][] getData() {
        String path = "C:\\Users\\rajat\\IdeaProjects\\CapistoneProject\\TestData\\TestData1.xlsx";
        ReadExcelFile file = new ReadExcelFile();
        Object[][] data = file.excelData(path, "Sheet1");

        return data;
    }




}
