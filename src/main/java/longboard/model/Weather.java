package longboard.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/** Represents a domain object for the total weather data (now and forecasts)
 * Created by ArtemParfenov on 20.08.2019.
 */
@Data
@Builder
public class Weather {
    /**time when weather service call was finished*/
    private Date serviceCallSuccessTime;
    private Condition now;
    private List<DayForecast> forecasts;
}
