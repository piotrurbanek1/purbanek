package pl.coderslab.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div")
    private WebElement signIn;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    private WebElement userPassword;

    @FindBy(xpath = "//*[@id=\"submit-login\"]")
    private WebElement confirm;





    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    public void logUser(String mail, String password) {
        signIn.click();
        email.clear();
        email.sendKeys(mail);
        userPassword.clear();
        userPassword.sendKeys(password);
        confirm.click();
    }
}

