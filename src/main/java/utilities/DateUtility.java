package utilities;

import java.time.Month;
import java.time.YearMonth;

public class DateUtility extends Utility{

    /** converts month to its number like: "December" to--> "12" */
    public static String getMonthNumber(String monthName) {
        int monthNum = Month.valueOf(monthName.toUpperCase()).getValue();
        return String.format("%02d", monthNum); // ensures leading zero
    }

}
