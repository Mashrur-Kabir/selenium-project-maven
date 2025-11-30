package utilities;

import com.saucedemo.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class Utility {

    public static WebDriver driver;

    public static void setUtilDriver() {
        driver = BasePage.driver; // assigns BasePage's driver to Utility's driver
    }


}
