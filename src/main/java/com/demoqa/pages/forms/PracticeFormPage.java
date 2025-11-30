package com.demoqa.pages.forms;

import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class PracticeFormPage extends FormsPage{

    private By femaleRadioButton = By.id("gender-radio-2");
    private By sportHobbyCheckbox = By.id("hobbies-checkbox-1");
    private By readingHobbyCheckbox = By.id("hobbies-checkbox-2");
    private By musicHobbyCheckbox = By.id("hobbies-checkbox-3");
    private By submitButton  = By.id("submit");

    public void clickFemaleRadioButton() {
        scrollToElementJS(femaleRadioButton);
        click(femaleRadioButton);
    }

    //verify button click
    public boolean isFemaleSelected() {
        return find(femaleRadioButton).isSelected();
    }

    //clicking checkboxes
    public void clickSportsCheckbox() {
        if (!find(sportHobbyCheckbox).isSelected()) { //if not selected
            scrollToElementJS(sportHobbyCheckbox);
            click(sportHobbyCheckbox);
        }
    }

    public void clickReadingCheckbox() {
        if (!find(readingHobbyCheckbox).isSelected()) {
            scrollToElementJS(readingHobbyCheckbox);
            click(readingHobbyCheckbox);
        }
    }

    public void clickMusicCheckbox() {
        if (!find(musicHobbyCheckbox).isSelected()) {
            scrollToElementJS(musicHobbyCheckbox);
            click(musicHobbyCheckbox);
        }
    }

    //unclicking one checkbox
    public void unclickReadingCheckbox() {
        if (find(readingHobbyCheckbox).isSelected()) { //if selected
            scrollToElementJS(readingHobbyCheckbox);
            click(readingHobbyCheckbox); //this is going to undo the already checked box
        }
    }

    //verify readingHobbyCheckbox is NOT selected
    public boolean isReadingCheckboxSelected() {
        return find(readingHobbyCheckbox).isSelected();
    }

    //this method is for the 'part4' of root package for all tests named "screenshot". Path: C:\Users\Ryan\IdeaProjects\SeleniumProjectsFCC\src\test\java\com\demoqa\base\tests\part4\screenshot\CaptureFailedScreenshotTest.java
    public void clickSubmitButton() {
        // scrollToElementJS(submitButton); because we will not scroll down to the element before clicking it, the test will fail
        click(submitButton);
    }

}
