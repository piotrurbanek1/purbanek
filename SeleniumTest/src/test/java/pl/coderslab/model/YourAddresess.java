package pl.coderslab.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class YourAddresess {

    private WebDriver driver;



    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/a/span")
    private WebElement createNewAddress;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement isItSuccess;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span")
    private WebElement deleteAddress;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement success;


    public YourAddresess(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void addAddressYourAddress(){
        createNewAddress.click();
    }
    public void addressCreated(){
        String expectedAlertText = "Address successfully added!";
        String alertText = isItSuccess.getText();
        assertEquals(expectedAlertText, alertText);
    }
    public void deleteAddress(){
        deleteAddress.click();
        String expectedAlert = "Address successfully deleted!";
        String alertText = success.getText();
         assertEquals(expectedAlert, alertText);

        driver.quit();

    }
}
