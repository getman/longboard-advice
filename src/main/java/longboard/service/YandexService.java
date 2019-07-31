package longboard.service;

import longboard.clients.YandexResponceJson;

/**
 * Created by ArtemParfenov on 22.07.2019.
 */
public interface YandexService {
    YandexResponceJson getWeather();
}
