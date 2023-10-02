package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage {

    WebDriver driver ;

    public ElectronicsPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//h2[contains(text(),\"Products in 'Electronics' category\")]")
    WebElement category;

    @FindBy(xpath = "//div[contains(text(),'s21')]")
    WebElement product ;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[2]/div/div/a[3]/div[3]")
    WebElement price;

    public String getCategory(){
        return category.getText();
    }

    public String getProduct(){

        return product.getText() ;

    }

    public String getPrice(){

        return price.getText();
    }


}
