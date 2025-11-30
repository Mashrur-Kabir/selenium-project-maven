package com.demoqa.base.tests.part3.forms;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    public void testRadioButton() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickFemaleRadioButton();
        boolean isFemaleRadiobtnSelected = formsPage.isFemaleSelected();
        Assert.assertTrue(isFemaleRadiobtnSelected,
                "\nActual: Female Radio btn is NOT selected.\nExpected: Female Radio btn SHOULD BE selected\n");
    }

}
