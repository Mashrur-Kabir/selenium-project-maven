package com.saucedemo.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.base.BaseTest;

public class LoginTests extends BaseTest {
    //flows that use loginpage methods--
    @Test
    public void testLoginErrorMessage() {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("xhhs120"); //wrong password
        loginPage.clickLoginButton(); //clicking to login button has a transition which returns products page.
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface") );
    }








}
