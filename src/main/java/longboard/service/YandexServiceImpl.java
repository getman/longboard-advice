package longboard.service;

import longboard.clients.YandexClient;
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
    public String getWeather() {
        return yaClient.requestYandexWeatherData();
    }


}
