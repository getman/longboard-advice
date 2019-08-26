package longboard.converter;

import longboard.clients.YandexResponseDto;
import longboard.clients.YandexResponseJson;
import longboard.model.Weather;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ArtemParfenov on 21.08.2019.
 */
public final class WeatherConverter {
    public static Weather fromYandexWeather(YandexResponseDto yandexWeatherDto) {
        return Weather.builder()
                .now(Optional.of(yandexWeatherDto)
                        .map(YandexResponseDto::getYandexResponseJson)
                        .map(YandexResponseJson::getFact)
                        .filter(Objects::nonNull)
                        .map(fact -> ConditionConverter.fromYandexFactConditions(fact))
                        .orElse(null))
                .forecasts(Optional.of(yandexWeatherDto)
                        .map(YandexResponseDto::getYandexResponseJson)
                        .map(YandexResponseJson::getForecasts)
                        .filter(Objects::nonNull)
                        .map(forecasts ->
                            forecasts.stream()
                                .map(forecast -> DayForecastConverter.fromYandexForecast(forecast))
                                .collect(Collectors.toList())
                        )
                        .orElse(null))
                .serviceCallSuccessTime(yandexWeatherDto.getServiceCallSuccessTime())
                .build();
    }
}
