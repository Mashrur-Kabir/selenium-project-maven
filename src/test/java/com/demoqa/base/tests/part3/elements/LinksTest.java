package com.demoqa.base.tests.part3.elements;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksTest extends BaseTest {

    @Test
    public void testLinks() {
        var linksPage = homePage.goToElements().clickLinks();
        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();
        Assert.assertTrue(actualResponse.contains("400")
                           && actualResponse.contains("Bad Request"),
                           "\nActual response: (" + actualResponse +
                                    ")\nwhich does NOT contain '400' and 'Bad Request'\n");

    }

}
