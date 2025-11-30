package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    //variables
    private By usernameField = By.id("user-name"); // with encapsulation, the fields are private, meaning, only the methods inside LoginPage will have access to them
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("#login_button_container h3");

    //methods that will perform actions--

    //setter method
    public void setUserName(String username) {
        set(usernameField, username); //basePage's set method
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    //transition method
    public ProductsPage clickLoginButton() {
        click(loginButton);
        return new ProductsPage();
    }

    //convenience method (handles the whole login process in one method)
    public ProductsPage logIntoApplication(String username, String password) {
        setUserName(username);
        setPassword(password);
        return clickLoginButton();
    }

    //getter method
    public String getErrorMessage() { //Used when we expect an error after invalid login.
        return find(errorMessage).getText();
    }

}


