package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitchenItemsPage {

    WebDriver driver;

    public KitchenItemsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Kitchen Items')]")
    WebElement kitchenItems ;

    @FindBy(xpath = "//div[contains(text(),'Prestige Stove')]")
    WebElement prestigeStoveText;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[2]/div/div/a[1]/div[3]")
    WebElement price;

    public void clickOnKitchenItems(){
        kitchenItems.click();
    }

    public String getProductText(){

        return prestigeStoveText.getText();

    }

    public String getPrice(){
        return price.getText();
    }





}
