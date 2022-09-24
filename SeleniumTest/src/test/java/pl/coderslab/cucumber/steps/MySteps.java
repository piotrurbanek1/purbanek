package pl.coderslab.cucumber.steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.AddAdress;
import pl.coderslab.model.LoginPage;
import pl.coderslab.model.YourAccount;
import pl.coderslab.model.YourAddresess;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MySteps {

    private WebDriver driver;



    @Given("open browser with {}")
    public void openBrowser(String url){
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        //        Otworz przegladarke
        this.driver = new ChromeDriver();
        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get(url);
    }

    @And("user is registered with {} and {}")
    public void logIn(String mail,String password){
        LoginPage loginPage=new LoginPage(this.driver);
        loginPage.logUser(mail,password);
    }


    @When("new address added with {} and {} and {} and {} and {}")
    public void fillNewAddress(String alias, String address, String city, String zipcode, String phone){
        YourAccount yourAccount= new YourAccount(this.driver);
        yourAccount.addAddress();
        YourAddresess yourAddresess= new YourAddresess(this.driver);
        yourAddresess.addAddressYourAddress();
        AddAdress addAdress=new AddAdress(this.driver);
        addAdress.fillNewAddress(alias,address,city,zipcode,phone);
    }
    @Then("new address is created")
    public void createAddress() {
        YourAddresess yourAddresess = new YourAddresess(this.driver);
        yourAddresess.addressCreated();
    }


   @And("new address is deleted and driver quit")
   public void deletesAddress() {
       YourAddresess yourAddresess = new YourAddresess(this.driver);
       yourAddresess.deleteAddress();
   }

}


