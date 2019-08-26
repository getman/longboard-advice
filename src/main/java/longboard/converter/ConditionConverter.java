package longboard.converter;

import longboard.clients.FactWeatherDto;
import longboard.clients.WeatherForDayPartDto;
import longboard.model.Condition;
import longboard.model.ForecastCondition;
import longboard.model.RainAndCloud;

import java.util.Optional;

import static longboard.converter.RainAndCloudConverter.*;

/**
 * Created by ArtemParfenov on 21.08.2019.
 */
public final class ConditionConverter {
    public static Condition fromYandexFactConditions(FactWeatherDto yandexFactCondition) {
        return Condition.builder()
                .temp(Optional.of(yandexFactCondition)
                        .map(FactWeatherDto::getTemp)
                        .map(temp -> Short.parseShort(temp))
                        .orElse(null))
                .feelsLike(Optional.of(yandexFactCondition)
                        .map(FactWeatherDto::getFeels_like)
                        .map(feelsLike -> Short.parseShort(feelsLike))
                        .orElse(null))
                .rainAndCloud(Optional.of(yandexFactCondition)
                        .map(FactWeatherDto::getCondition)
                        .map(cond -> RainAndCloudConverter.fromYandexRainAndCloud(cond))
                        .orElse(null))
                .build();
    }

    public static ForecastCondition fromYandexForecastConditions(WeatherForDayPartDto dayPartDto) {
        return ForecastCondition.builder()
                .tMin(Short.parseShort(dayPartDto.getTemp_min()))
                .tMax(Short.parseShort(dayPartDto.getTemp_max()))
                .rainAndCloud(RainAndCloudConverter.fromYandexRainAndCloud(dayPartDto.getCondition()))
                .build();
    }
}
