package longboard.clients;

import lombok.Data;

/**Represents the whole day weather
 * Created by ArtemParfenov on 31.07.2019.
 */
@Data
public class WeatherForDay {
    private WeatherForDayPart night;
    private WeatherForDayPart morning;
    private WeatherForDayPart day;
    private WeatherForDayPart evening;
    private WeatherForDayPart day_short;
    private WeatherForDayPart night_short;
}
