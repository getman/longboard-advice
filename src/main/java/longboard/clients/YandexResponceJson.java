package longboard.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ArtemParfenov on 23.07.2019.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class YandexResponceJson {

    private String now;
    private String now_dt;

    public YandexResponceJson() {
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

    @Override
    public String toString() {
        return "YandexResponceJson{" +
                "now=" + now +
                ", now_dt='" + now_dt + '\'' +
                '}';
    }
}