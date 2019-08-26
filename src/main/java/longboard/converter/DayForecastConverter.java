package longboard.converter;

import longboard.clients.DayForecastDto;
import longboard.model.DayForecast;

import java.time.LocalDate;

/**
 * Created by ArtemParfenov on 22.08.2019.
 */
public final class DayForecastConverter {
    public static DayForecast fromYandexForecast(DayForecastDto yandexForecast) {
        return DayForecast.builder()
                .date(LocalDate.of(
                        yandexForecast.getDate().getYear(),
                        yandexForecast.getDate().getMonth(),
                        yandexForecast.getDate().getDay()))
                .night(ConditionConverter.fromYandexForecastConditions(
                        yandexForecast.getParts().getNight()))
                .morning(ConditionConverter.fromYandexForecastConditions(
                        yandexForecast.getParts().getMorning()))
                .day(ConditionConverter.fromYandexForecastConditions(
                        yandexForecast.getParts().getDay()))
                .evening(ConditionConverter.fromYandexForecastConditions(
                        yandexForecast.getParts().getEvening()))
                .build();
    }
}
