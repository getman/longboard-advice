package longboard.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ArtemParfenov on 30.07.2019.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FactWeatherData {
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

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(String wind_gust) {
        this.wind_gust = wind_gust;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getPressure_mm() {
        return pressure_mm;
    }

    public void setPressure_mm(String pressure_mm) {
        this.pressure_mm = pressure_mm;
    }

    public String getPressure_pa() {
        return pressure_pa;
    }

    public void setPressure_pa(String pressure_pa) {
        this.pressure_pa = pressure_pa;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getUv_index() {
        return uv_index;
    }

    public void setUv_index(String uv_index) {
        this.uv_index = uv_index;
    }

    public String getSoil_temp() {
        return soil_temp;
    }

    public void setSoil_temp(String soil_temp) {
        this.soil_temp = soil_temp;
    }

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
