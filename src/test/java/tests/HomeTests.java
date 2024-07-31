package tests;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SellerPage;
import utilities.Driver;

public class HomeTests {


    WebDriver driver = Driver.getDriver();

    HomePage homePage = new HomePage();

@Test
public void testLogin(){
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com","admin1234");





}






}
