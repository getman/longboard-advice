package longboard.util;

import lombok.experimental.UtilityClass;

import java.util.Date;

/**
 * Created by ArtemParfenov on 24.08.2019.
 */
@UtilityClass
public final class HtmlStyle {
    public static String getDayPartStyleTag(boolean isToday, Date nowTime, Date forecastDateStartPeriod, Date forecastDateEndPeriod) {
        if (isToday && nowTime.after(forecastDateStartPeriod) && nowTime.before(forecastDateEndPeriod)) {
            return "style=\"color:red;font-weight: bold\"";
        } else if (isToday && nowTime.after(forecastDateEndPeriod)) {
            return "style=\"color:grey;\"";
        } else {
            return "";
        }
    }
}
