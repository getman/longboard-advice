package longboard.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/** Represents the forecast for a day
 * Created by ArtemParfenov on 21.08.2019.
 */
@Data
@Builder
public class DayForecast {
    private LocalDate date;
    private ForecastCondition night;
    private ForecastCondition morning;
    private ForecastCondition day;
    private ForecastCondition evening;
}
