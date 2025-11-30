package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility extends Utility {

    //scroll to element before action
    public static void scrollToElementJS(By locator){
        WebElement element = driver.findElement(locator);
        String jsScripts = "arguments[0].scrollIntoView();"; //a string that will store “Scroll the page so that the specified element (argument[0]) is visible in the viewport.”
        ((JavascriptExecutor)driver).executeScript(jsScripts, element); //when we typecast javaScript executor, the driver can execute the script (like the above string) when passing in valid arguments
    }

}

//When you use:
//((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

//you bypass Selenium’s “human-like” interaction rules entirely.
//You directly tell the browser’s DOM engine:
//  “Call the .click() method on this element in JavaScript.”

//It doesn’t care if:

//-the element is off-screen,
//-overlapped,
//-hidden behind a label, or
//-covered by an animation.

//It simply triggers the event in the DOM — like programmatically firing a click.
//That’s why JavaScript clicks “magically” work in those tricky cases.