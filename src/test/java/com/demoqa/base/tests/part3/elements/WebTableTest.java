package com.demoqa.base.tests.part3.elements;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest extends BaseTest {

    @Test
    public void testWebTable() {

        String email = "cierra@example.com";
        String expectedAge = "46";

        var webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickEdit(email);
        webTablePage.setAge("46");
        webTablePage.clickSubmitButton();
        String actualAge = webTablePage.getTableAge(email); //getting the updated age
        //verify
        Assert.assertEquals(actualAge, expectedAge,
                "\nActual and Expected age DO NOT match\n");
    }

}

