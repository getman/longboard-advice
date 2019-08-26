package longboard.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**Represents the whole day weather
 * Created by ArtemParfenov on 31.07.2019.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForDayDto {
    private WeatherForDayPartDto night;
    private WeatherForDayPartDto morning;
    private WeatherForDayPartDto day;
    private WeatherForDayPartDto evening;
    private WeatherForDayPartDto day_short;
    private WeatherForDayPartDto night_short;
}
