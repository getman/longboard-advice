package longboard.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**Performs calling the Yandex API to receive the longboard.clients data
 * Created by ArtemParfenov on 22.07.2019.
 */
@Slf4j
@Component
@CacheConfig(cacheNames = {"yandexweather"})
public class YandexClient {
    @Cacheable
    public YandexResponseDto requestYandexWeatherData() {
        log.debug("YandexClient. Weather for moscow was requested");
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> params = new HashMap<>();
        params.put("lat", "55.75396");
        params.put("lon", "37.620393");
        String url = "https://api.weather.yandex.ru/v1/informers/?lat=55.75396&lon=37.620393";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Yandex-API-Key", "8f612c37-1e1a-4c2a-a93a-8d37c00ff3b7");
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity<YandexResponseJson> response = restTemplate.exchange(url, HttpMethod.GET, entity,
                YandexResponseJson.class, params);
        log.trace("Yandex.Weather respond with:{}", response.getBody());
        return YandexResponseDto.builder()
                .yandexResponseJson(response.getBody())
                .serviceCallSuccessTime(new Date())
                .build();
    }


}
