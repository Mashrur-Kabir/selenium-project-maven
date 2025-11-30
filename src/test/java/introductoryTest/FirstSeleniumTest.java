package introductoryTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver; //Webdriver control the browser and help find elements

    @BeforeClass //means run the below code before the class
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //loads new webpage
    }

    @AfterClass //helps clean up our tests and operates like a post condition
    public void tearDown(){
       // driver.quit(); //closes all window
    }

    @Test //this annotation identifies test method
    public void testLoggingIntoApplication() throws InterruptedException {
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username")); //"find the element by name locator"
        username.sendKeys("Admin"); //performing an action on the element
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(3000);
        driver.findElement(By.tagName("button")).click(); //finding element without object ref and clicking on it.

        //FOR VERIFYING TEST WITH AN ASSERTION, WE WILL USE TESTNG
        Thread.sleep(2000);
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";

        Assert.assertEquals(actualResult, expectedResult); //comparing if two values are equal to verify the test
        //verifying tests by texts that are inside the elements and in the UI. find -> //h6
    }

    //Term: AUT = Application Under Test

    // POM:
    // 1. Page object = web page.
    // variable inside page object class are elements of webpage. methods interact with those elements and allow us to represent the behavior of the AUT
    // 2. Test scripts = steps we automate and verify the application
    // Each test scripts have access to all page object class.
    // They also make calls to page objects as they have access to the variables received from webpage and the methods emulate actions from web pages.
    // Test scripts can call the BaseTest and Page object can call BasePage (Although they are not mandatory for POM)
    // BasePage has methods common to all page object classes
    // Similarly, BaseTest has information common to all tests and instructions that help prevent repetition of tests (setUp(), tearDown())

}
