package pl.coderslab.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAdress {


        private WebDriver driver;





        @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
        private WebElement fillAllias;

        @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")
        private WebElement fillAddress;

        @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")
        private WebElement fillCity;

        @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
        private WebElement fillZip;

         @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")
        private WebElement fillPhone;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButton;

        public AddAdress(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }
    public void fillNewAddress(String alias, String address, String city, String zipcode, String phone){


        fillAllias.sendKeys(alias);
        fillAddress.sendKeys(address);
        fillCity.sendKeys(city);
        fillZip.sendKeys(zipcode);
        fillPhone.sendKeys(phone);
        saveButton.click();
    }
    }

