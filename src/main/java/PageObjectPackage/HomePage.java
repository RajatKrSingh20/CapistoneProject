package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver ;

    public HomePage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[contains(text(),'test001')]")
    WebElement id ;

    @FindBy(xpath = "//div[contains(text(),'Logout')]")
    WebElement logoutButton;


    public String verifyID(){

        return id.getText();

    }

    public void clickOnLogout(){
        logoutButton.click();
    }




}
