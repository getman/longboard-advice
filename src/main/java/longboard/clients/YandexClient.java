package longboard.clients;

import org.springframework.stereotype.Component;

/**Performs calling the Yandex API to receive the longboard.clients data
 * Created by ArtemParfenov on 22.07.2019.
 */
@Component
public class YandexClient {
    public String requestYandexWeatherData() {
        return "122 cel from Yandex";
    }
}
