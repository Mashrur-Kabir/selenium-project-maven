package com.demoqa.base.tests.part3.widgets;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ScrollSelectDropdownTest extends BaseTest {

    @Test
    public void testMultiSelectDropDown() {
        var selectMenuPage = homePage.goToWidgets().clickSelectMenu();
        selectMenuPage.selectStandardMulti("Volvo"); //can take arguments of different data types since its there's a method overloading in the selectMenuPage
        selectMenuPage.selectStandardMulti(1);
        selectMenuPage.selectStandardMulti("Audi");
        selectMenuPage.selectStandardMulti(2);

        //deselect
        selectMenuPage.deselectStandardMulti("saab");

        //verify
        List<String> actualSelectedOptions = selectMenuPage.getAllSelectedStandardMultiOptions();
        Assert.assertTrue(actualSelectedOptions.contains("Volvo")); // <-- not necessarily in order
        Assert.assertTrue(actualSelectedOptions.contains("Opel"));
        Assert.assertTrue(actualSelectedOptions.contains("Audi"));
        Assert.assertFalse(actualSelectedOptions.contains("Saab"),
                "\nActual: 'Saab' is selected as an option.\nExpected: 'Saab' should NOT be selected.\n");

    }

}
