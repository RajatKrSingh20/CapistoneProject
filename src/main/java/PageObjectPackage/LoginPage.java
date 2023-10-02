package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    WebDriver driver ;

    public LoginPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[contains(text(),'Login')]")
    WebElement loginButton ;

    @FindBy(xpath="//h4[contains(text(),'Login')]")
    WebElement loginText ;

    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameField ;

    @FindBy(xpath="//input[@id='password']")
    WebElement passwordField ;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement loginButton2;

    @FindBy(xpath = "//div[contains(text(),'Username and Password are required!!')]")
    WebElement validationMessage;

    public void clickOnLogin(){
        loginButton.click();
    }

    public String verifyText(){
        return loginText.getText();
    }

    public void enterUserName(String username){
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickOnSubmit(){
        loginButton2.click();
    }

    public boolean validateMessage(){

      boolean result =   validationMessage.isDisplayed();

      return result ;

    }


}
