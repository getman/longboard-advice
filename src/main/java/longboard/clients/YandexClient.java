package longboard.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**Performs calling the Yandex API to receive the longboard.clients data
 * Created by ArtemParfenov on 22.07.2019.
 */
@Slf4j
@Component
public class YandexClient {
    public YandexResponceJson requestYandexWeatherData() {
        log.debug("YandexClient. Weather for moscow was requested");
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> params = new HashMap<>();
        params.put("lat", "55.75396");
        params.put("lon", "37.620393");
        String url = "https://api.weather.yandex.ru/v1/forecast/?lat=55.75396&lon=37.620393";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Yandex-API-Key", "f00433c0-0060-4ef8-b9bb-72debb6b719f");
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity<YandexResponceJson> response = restTemplate.exchange(url, HttpMethod.GET, entity,
                YandexResponceJson.class, params);
        log.trace("Yandex.Weather respond with:{}", response.getBody());
        return response.getBody();
    }


}