package longboard.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**Represents the whole day weather
 * Created by ArtemParfenov on 31.07.2019.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForDay {
    private WeatherForDayPart night;
    private WeatherForDayPart morning;
    private WeatherForDayPart day;
    private WeatherForDayPart evening;
    private WeatherForDayPart day_short;
    private WeatherForDayPart night_short;
}
