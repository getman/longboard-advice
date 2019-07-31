package longboard.service;

import longboard.clients.YandexClient;
import longboard.clients.YandexResponceJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ArtemParfenov on 22.07.2019.
 */
@Component
public class YandexServiceImpl implements YandexService {
    @Autowired
    private YandexClient yaClient;

    @Override
    public YandexResponceJson getWeather() {
        return yaClient.requestYandexWeatherData();
    }


}
