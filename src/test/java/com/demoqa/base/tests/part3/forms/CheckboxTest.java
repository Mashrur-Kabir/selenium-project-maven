package com.demoqa.base.tests.part3.forms;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {

    @Test
    public void testCheckbox() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickSportsCheckbox();
        formsPage.clickReadingCheckbox();
        formsPage.clickMusicCheckbox();
        formsPage.unclickReadingCheckbox();

        boolean isReadingCheckboxSelected = formsPage.isReadingCheckboxSelected();
        Assert.assertFalse(isReadingCheckboxSelected, //assertFalse = I am expecting a false value from boolean variable
                "\nActual: The reading checkbox IS selected\nExpected: The reading checkbox should NOT be selected\n");
    }







}
