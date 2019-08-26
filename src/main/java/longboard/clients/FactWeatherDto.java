package longboard.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by ArtemParfenov on 30.07.2019.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FactWeatherDto {
    private String temp;
    private String feels_like;
    private String icon;
    private String condition;
    private String wind_speed;
    private String wind_gust;
    private String wind_dir;
    private String pressure_mm;
    private String pressure_pa;
    private String humidity;
    private String uv_index;
    private String soil_temp;

    @Override
    public String toString() {
        return "fact: {" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                ", icon=" + icon +
                ", condition=" + condition +
                ", wind_speed=" + wind_speed +
                ", wind_gust=" + wind_gust +
                ", wind_dir=" + wind_dir +
                ", pressure_mm=" + pressure_mm +
                ", pressure_pa=" + pressure_pa +
                ", humidity=" + humidity +
                ", uv_index=" + uv_index +
                ", soil_temp=" + soil_temp +
                '}';
    }
}
