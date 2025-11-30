package com.saucedemo.base;
//you create the base test after creating the home page
import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    //variables
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    private String url = "https://saucedemo.com";

    //Now we will setup for each test, load the application and tear it down upon completion
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(); //initialize driver
        driver.manage().window().maximize();
        driver.get(url); //loading application

        basePage = new BasePage(); //instance of basepage
        basePage.setDriver(driver); //share the driver with BasePage (and all its children)

        loginPage = new LoginPage(); //instance of loginpage is created (it inherits the driver via BasePage).
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
