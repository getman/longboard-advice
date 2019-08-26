package longboard.service;

import longboard.clients.YandexClient;
import longboard.clients.YandexResponseDto;
import longboard.clients.YandexResponseJson;
import longboard.converter.WeatherConverter;
import longboard.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by ArtemParfenov on 22.07.2019.
 */
@Component
public class YandexServiceImpl implements YandexService {
    @Autowired
    private YandexClient yaClient;

    @Override
    public Weather getWeather() {
        return Optional.ofNullable(yaClient.requestYandexWeatherData())
                .map(dto -> WeatherConverter.fromYandexWeather(dto))
                .orElse(null);
    }


}
