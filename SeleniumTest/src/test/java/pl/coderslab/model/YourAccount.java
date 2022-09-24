package pl.coderslab.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccount {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"addresses-link\"]/span/i")
    private WebElement addAddress;





    public YourAccount(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
public void addAddress(){
        addAddress.click();
}

}
