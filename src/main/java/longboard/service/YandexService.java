package longboard.service;

import longboard.clients.YandexResponseDto;

/**
 * Created by ArtemParfenov on 22.07.2019.
 */
public interface YandexService {
    YandexResponseDto getWeather();
}
