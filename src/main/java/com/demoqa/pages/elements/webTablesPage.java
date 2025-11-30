package com.demoqa.pages.elements;

import org.openqa.selenium.By;

public class webTablesPage extends ElementsPage{

    //Fields
    private By registrationAgeField = By.id("age");
    private By submitButton = By.id("submit");


    //For clicking the edit button---
    //we only create a method here instead of locating a particular edit element because an email (element we are using to locate the edit button) can change depending on which record we prefer to update
    public void clickEdit(String email) { //value our test will pass in for dynamically locating any edit button for a given email
        By edit = By.xpath("//div[text()='"+ email +"']//following::span[@title='Edit']"); // "+ email +" to append the parameter instead of a hardcoded email value
        click(edit); //will open a modal
    }

    public void setAge(String age) { //value of 'age' that we pass in the test
        set(registrationAgeField, age); //updating value
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    //verify
    public String getTableAge(String email) {
        By tableAge = By.xpath("//div[text()='"+ email +"']//preceding::div[1]");
        return find(tableAge).getText();
    }

}
