package DemoSitePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoAppClass {

    WebDriver driver ;

    WebElement userId ;
    WebElement password ;
    WebElement loginButton ;

    WebElement amount ;

    ArrayList<String>list2;
    ArrayList<Double>list3;


    @BeforeTest

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://sakshingp.github.io/assignment/login.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userId = driver.findElement(By.xpath("//input[@id='username']"));
        password = driver.findElement(By.xpath("//input[@id='password']"));
        loginButton = driver.findElement(By.xpath("//button[@id='log-in']"));
    }

    @Test(priority = 1)
    public void login(){

        userId.sendKeys("123");
        password.sendKeys("123");
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void verify(){





        amount = driver.findElement(By.xpath("//th[@id='amount']"));
        amount.click();
        List<WebElement> list = driver.findElements(By.xpath("//span[contains(text(),' USD')]"));

        Iterator<WebElement>itr = list.iterator();
        list2  = new ArrayList<>();
        while(itr.hasNext()){

            String text = itr.next().getText();
            text = text.replace("USD","");
            text = text.replace(" ","");
            text = text.replace(",","");
            list2.add(text);
        }
        System.out.println(list2);

       list3 = new ArrayList<>();

        for(int i = 0; i<list2.size();i++){

            Double value = Double.valueOf(list2.get(i));

            list3.add(value);
        }

        ArrayList<Double>list4 = new ArrayList<>(list3);

        System.out.println("list3 "+list3);
        System.out.println("list4 "+list4);

        Collections.sort(list4);
        System.out.println("list4 "+list4);

        Assert.assertEquals(list3,list4,"mismatched");
        System.out.println("yes, numbers are in ascending order");










    }









}
