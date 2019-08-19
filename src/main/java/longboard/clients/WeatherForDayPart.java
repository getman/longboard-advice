package longboard.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/** Represents the average weather for the day part: morning, night, etc
 * Created by ArtemParfenov on 31.07.2019.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForDayPart {
    private String temp_min;
    private String temp_max;
    private String condition;
}
