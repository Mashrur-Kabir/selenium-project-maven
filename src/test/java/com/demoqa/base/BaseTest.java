package com.demoqa.base;

import com.demoqa.pages.HomePage;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import org.openqa.selenium.io.FileHandler;


import static utilities.Utility.setUtilDriver;

public class BaseTest {

    //variables
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String DEMOQA_URL = "https://demoqa.com/";

    @BeforeClass //Runs once before all test methods in the class
    public void setUp() {
        driver = new ChromeDriver(); //classes will communicate with chrome browser
        driver.manage().window().maximize();
    }

    @BeforeMethod //Runs before every single test method
    public void loadApplication() {
        driver.get(DEMOQA_URL);
        basePage = new BasePage(); //create an instance of BasePage
        basePage.setDriver(driver); //Basepage gets the driver for sharing
        setUtilDriver(); //because JavaScriptUtility inherits from Utility and the driver there will have been initialized from here.
        homePage = new HomePage(); //since every test must go through homepage since browser will reopen
    }

    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver; //see: (1)
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" +
                    LocalDate.now() +
                    testResult.getName() + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot located at: " + destination);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

// IMPORTANT:
// In SauceDemo:
//      driver.get(url); was in @BeforeClass
// → meaning the browser opens the site once, and all tests run in that same session.

// In DemoQA:
//      driver.get(DEMOQA_URL); was moved to @BeforeMethod
// → so before every test, it reloads the homepage from scratch.

// (1) Typecasting explanation:
// TakesScreenshot is an interface (a blueprint of a class. contains abstract methods which doesn't have logic/body. The class implementing them would have to write the logic for those methods to suit their needs. Note: Default or static methods do contain logic/body)
// ChromeDriver implements that interface as getScreenShotAs().
// Java doesn't know any method ChromeDriver has and treats the object (WebDriver driver = new ChromeDriver();) as a WebDriver-type reference, so it only exposes methods declared in the WebDriver interface (like get(), findElement(), etc.)
// But there are extra ones from other interfaces ChromeDriver implements (like TakesScreenshot or JavascriptExecutor). For them, we need typecast to tell Java that the instance can also take "screenshots"
// We wouldn't need the typecasting if the variable was declared as "ChromeDriver driver = new ChromeDriver();"



