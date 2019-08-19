package longboard.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.datatype.XMLGregorianCalendar;

/** Forecast for a day
 * Created by ArtemParfenov on 31.07.2019.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DayForecast {
    private XMLGregorianCalendar date;
    private WeatherForDay parts;
}
