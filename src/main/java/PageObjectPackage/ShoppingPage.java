package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {

    WebDriver driver;

    public ShoppingPage(WebDriver driver){

        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[contains(text(),'Electronics')]")
    WebElement electronics ;

    @FindBy(xpath = "//a[contains(text(),'Kitchen Items')]")
    WebElement kitchenItems ;

    @FindBy(xpath = "//a[contains(text(),'Sports')]")
    WebElement sports ;

    @FindBy(xpath="//h2[contains(text(),'Welcome to Online Shopping ...')]")
    WebElement welcomeText ;

    public boolean verifyWelcomeText(){
        boolean result = welcomeText.isDisplayed();
        return result ;
    }

    public void clickOnElectronics(){
        electronics.click();
    }

    public void clickOnKitchenItems(){
        kitchenItems.click();
    }

    public void clickOnSports(){
        sports.click();
    }






}
