package longboard.clients;

import lombok.Data;

/** Represents the average weather for the day part: morning, night, etc
 * Created by ArtemParfenov on 31.07.2019.
 */
@Data
public class WeatherForDayPart {
    private String temp_min;
    private String temp_max;
    private String condition;
}
