package com.demoqa.pages.widgets;

import org.openqa.selenium.By;

import static utilities.DropDownUtility.selectByVisibleText;

public class DatePickerMenuPage extends WidgetsPage{

    private By selectDateField = By.id("datePickerMonthYearInput");
    private By monthDropDown = By.className("react-datepicker__month-select");
    private By yearDropDown = By.cssSelector(".react-datepicker__year-select");

    private By dayValue(String day) { //private because our test does not need to access the method
        return By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day')][text()='"+ day +"']");
    }

    public void clickSelectDate() {
        click(selectDateField);
    }

    //we'll call methods from dropdownutility utility class to select in various ways
    public void selectMonth(String month) {
        selectByVisibleText(monthDropDown, month);
    }

    public void selectYear(String year) {
        selectByVisibleText(yearDropDown, year);
    }

    //confirming if the day exists in that month
    public boolean isDayInMonth(String day) {
        try {
            return find(dayValue(day)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectDay(String day) {
        if (isDayInMonth(day)) {
            click(dayValue(day));
        } else {
            throw new IllegalArgumentException("Day " + day + " not available in the current month/year");
        }
    }

    public String getDate() {
        return find(selectDateField).getAttribute("value"); //because the 'value' attribute contains the date; which will be used to verify the date in test script
    }


}
