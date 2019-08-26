package longboard.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Created by ArtemParfenov on 23.07.2019.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class YandexResponseJson {

    private String now;
    private String now_dt;
    /**current weather data*/
    private FactWeatherDto fact;
    private List<DayForecastDto> forecasts;

    public YandexResponseJson() {
    }

    @Override
    public String toString() {
        return "YandexResponseJson{" +
                "now=" + now +
                ", now_dt='" + now_dt + '\'' +
                ", fact=" + fact +
                ", forecasts=" + forecasts +
                '}';
    }
}
