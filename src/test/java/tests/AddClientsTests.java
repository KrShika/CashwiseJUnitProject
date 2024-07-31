package tests;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.AddClientsPage;
import pages.HomePage;
import utilities.Driver;
import utilities.SeleniumUtils;

public class AddClientsTests {



    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    AddClientsPage addClientsCashwise= new AddClientsPage();
    Faker faker = new Faker();


    @Test
    public void testAddClients() {
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com","admin1234");
        addClientsCashwise.sales.click();
        addClientsCashwise.buttonAddClient.click();
        addClientsCashwise.clientsTagsInput.click();
        SeleniumUtils.waitForSeconds(3);
        addClientsCashwise.selecttesttag.click();
        addClientsCashwise.fullNameInput.sendKeys(faker.name().fullName());
        addClientsCashwise.companyInput.sendKeys(faker.name().fullName());
        addClientsCashwise.emailInput.sendKeys(faker.name().username()+"@gmail.com");
        addClientsCashwise.phoneNumberInput.sendKeys(faker.phoneNumber().phoneNumber());
        addClientsCashwise.addressInput.sendKeys(faker.address().fullAddress());
        addClientsCashwise.saveButton.click();



    }


    @Test
    public void verifyAddClientNegative(){
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com","admin1234");

        addClientsCashwise.sales.click();
        addClientsCashwise.buttonAddClient.click();
        addClientsCashwise.clientsTagsInput.sendKeys(faker.name().title());
        addClientsCashwise.fullNameInput.sendKeys(faker.name().fullName());

        addClientsCashwise.emailInput.sendKeys(faker.name().username());
        addClientsCashwise.phoneNumberInput.sendKeys(faker.phoneNumber().phoneNumber());
        addClientsCashwise.addressInput.sendKeys(faker.address().fullAddress());

        addClientsCashwise.saveButton.click();
    }
}
