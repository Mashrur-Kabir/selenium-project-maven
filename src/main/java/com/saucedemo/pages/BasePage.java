package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver; //Assigns driver to the class variable. We call it once in setup (BaseTest), so all pages can use it.
    }

    //helper methods---
    protected WebElement find(By locator) { //protected because we only want to reuse this method in our base page and all page object classes. Tests should call page actions (like setUserName), not raw finds.
        return driver.findElement(locator);
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        try {
            // Try normal Selenium click first
            find(locator).click();
        } catch (Exception e) {
            System.out.println("⚠️ Normal click failed, using JavaScript click instead: " + e.getMessage());
            try {
                WebElement element = find(locator);
                ((org.openqa.selenium.JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", element);
            } catch (Exception jsEx) {
                System.out.println("❌ JavaScript click also failed: " + jsEx.getMessage());
                throw jsEx; // Re-throw so test fails visibly if both methods fail
            }
        }
    }

}
