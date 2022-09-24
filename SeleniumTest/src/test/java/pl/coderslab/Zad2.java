package pl.coderslab;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import pl.coderslab.model.LoginPage;

import java.io.File;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Zad2 {
    private WebDriver driver;

    private static String number = "5";

    //@FindBy(xpath = "//*[@id=\"category-3\"]/a")
    //public WebElement choose ;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get("https://mystore-testlab.coderslab.pl");
    }



    @Test


    public void loginToShop(){

        String expectedAlert = "SAVE 20%";

        LoginPage loginPage=new LoginPage(this.driver);
        loginPage.logUser("aaas@gmail.com","12345");
        WebElement choose = this.driver.findElement(By.xpath("//*[@id=\"category-3\"]/a"));
        choose.click();
        WebElement chooseSweater = this.driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/div[1]/h2/a"));
        chooseSweater.click();
        WebElement checkDiscount = this.driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[2]"));
        String discountText = checkDiscount.getText();
        assertEquals(expectedAlert,discountText);


        WebElement changeSize = this.driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
        changeSize.click();
        WebElement chooseSize = this.driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
        chooseSize.click();

        WebElement upClick = this.driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i"));
        upClick.click();
        upClick.click();
        upClick.click();
        upClick.click();
        //WebElement countOfUnits = this.driver.findElement(By.id("quantity_wanted"));
        //countOfUnits.click();
        // clear nie czysci prawidlowo w tym przypadku i delete tez nie
        //countOfUnits.sendKeys(Keys.BACK_SPACE);
        //countOfUnits.sendKeys(number);

        WebElement addToCart = this.driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addToCart.click();


        WebElement proceedCheckout = this.driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        proceedCheckout.click();
        WebElement proceedToCheckout = this.driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        proceedToCheckout.click();


        WebElement addressConfirm = this.driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
        addressConfirm.click();


        WebElement chooseShipping = this.driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span/span"));
        chooseShipping.click();
        WebElement continueToPayment = this.driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
        continueToPayment.click();


        WebElement payByCheck = this.driver.findElement(By.xpath("//*[@id=\"payment-option-1-container\"]/label/span"));
        payByCheck.click();


        WebElement termsOfService = this.driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]"));
        termsOfService.click();
        WebElement obligationToPayButton = this.driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        obligationToPayButton.click();


        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        driver.quit();
    }
}
