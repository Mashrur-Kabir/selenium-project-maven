package com.demoqa.base.tests.part4.modals;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalTest extends BaseTest {

    @Test
    public void testModalDialog() {
        var afwPage = homePage.goToAlertFramesWindowsCard();
        var modalDialogsPage = afwPage.clickModalDialogs();
        modalDialogsPage.clickSmallModalButton();
        String actualText = modalDialogsPage.getSmallModalText();
        Assert.assertTrue(actualText.contains("small modal"),
                "\n actual: The message does NOT contain 'small modal'\n expected: The message SHOULD contain 'small modal' text");
        modalDialogsPage.clickCloseButton();
    }






}
