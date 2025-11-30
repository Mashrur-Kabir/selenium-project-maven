package com.demoqa.pages;

import com.demoqa.pages.alerts_frames_windows.Alerts_Frames_WindowsPage;
import com.demoqa.pages.elements.ElementsPage;
import com.demoqa.pages.forms.FormsPage;
import com.demoqa.pages.widgets.WidgetsPage;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class HomePage extends BasePage {

    //starting fields in the home page
    private By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private By elementsCard = By.xpath("//div[@id='app']//h5[text()='Elements']");
    private By widgetCard = By.xpath("//div[@id='app']//h5[text()='Widgets']");
    private By alertFrameWindowsCard = By.xpath("//div[@id='app']//h5[contains(text(), 'Alerts')]");




    //transition methods--
    public FormsPage goToForms() {
        scrollToElementJS(formsCard);
        click(formsCard);
        return new FormsPage();
    }

    public ElementsPage goToElements() {
        scrollToElementJS(elementsCard);
        click(elementsCard);
        return new ElementsPage();
    }

    public WidgetsPage goToWidgets() {
        scrollToElementJS(widgetCard);
        click(widgetCard);
        return new WidgetsPage();
    }

    public Alerts_Frames_WindowsPage goToAlertFramesWindowsCard() {
        scrollToElementJS(alertFrameWindowsCard);
        click(alertFrameWindowsCard);
        return new Alerts_Frames_WindowsPage();
    }



}
