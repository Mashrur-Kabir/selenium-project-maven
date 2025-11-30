package com.demoqa.base.tests.part3.widgets;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateUtility;

public class DateTest extends BaseTest {

    @Test
    public void testSelectingDate() {
        String month = "December";
        String day = "31";
        String year = "2033";

        //using month->month-number utility class for verifying date
        String monthNumber = DateUtility.getMonthNumber(month);

        var datePickerPage = homePage.goToWidgets().clickDatePicker();
        datePickerPage.clickSelectDate();
        datePickerPage.selectMonth(month);
        datePickerPage.selectYear(year);
        datePickerPage.selectDay(day);

        //verify final date
        String actualDate = datePickerPage.getDate();
        String expectedDate = monthNumber + "/" + day + "/" + year;

        Assert.assertEquals(actualDate, expectedDate,
                "\nActual: " + actualDate +
                        " does not match expected date\nExpected: " + expectedDate + "\n");
    }

}
