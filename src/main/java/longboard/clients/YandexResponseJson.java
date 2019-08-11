package longboard.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by ArtemParfenov on 23.07.2019.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class YandexResponseJson {

    private String now;
    private String now_dt;
    /**current weather data*/
    private FactWeatherData fact;
    private List<DayForecast> forecasts;

    public YandexResponseJson() {
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getNow_dt() {
        return now_dt;
    }

    public void setNow_dt(String now_dt) {
        this.now_dt = now_dt;
    }

    public FactWeatherData getFact() {
        return fact;
    }

    public void setFact(FactWeatherData fact) {
        this.fact = fact;
    }

    public List<DayForecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<DayForecast> forecasts) {
        this.forecasts = forecasts;
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
