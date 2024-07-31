package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SellerPage;
import utilities.Driver;

public class SellerTests {


    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    SellerPage sellerPage = new SellerPage();
    Faker faker = new Faker();


    @Test
    public void verifyAddSeller() {
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com", "admin1234");
        sellerPage.expenses.click();
        sellerPage.buttonAddSeller.click();
        sellerPage.titleInput.sendKeys(faker.name().title());
        sellerPage.fullNameInput.sendKeys(faker.name().fullName());
        sellerPage.emailInput.sendKeys(faker.name().username()+"@gmail.com");
        sellerPage.phoneNumberInput.sendKeys(faker.phoneNumber().phoneNumber());
        sellerPage.addressInput.sendKeys(faker.address().fullAddress());
        sellerPage.saveButton.click();
        String actual = "https://cashwise.us/dashboard/costs/sellers/active?isCreate=true";
        System.out.println(driver.getCurrentUrl());
        String expected = "https://cashwise.us/dashboard/costs/sellers/active?isCreate=false";
        Assert.assertFalse(actual.equals(expected));






    }


    @Test
    public void verifyAddSellerNegative(){
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com","admin1234");
        sellerPage.expenses.click();
        sellerPage.buttonAddSeller.click();
        sellerPage.titleInput.sendKeys(faker.name().title());
        sellerPage.fullNameInput.sendKeys(faker.name().fullName());
        sellerPage.emailInput.sendKeys(faker.name().username());
        sellerPage.phoneNumberInput.sendKeys(faker.phoneNumber().phoneNumber());
        sellerPage.addressInput.sendKeys(faker.address().fullAddress());
        sellerPage.saveButton.click();
        String actual = driver.findElement(By.xpath("//p[text()=\"Please enter a valid email address\"]")).getText();
        String expected = "Please enter a valid email address";
        Assert.assertTrue(expected.contains(actual));
    }

}
