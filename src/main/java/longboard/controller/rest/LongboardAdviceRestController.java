package longboard.controller.rest;

import lombok.extern.slf4j.Slf4j;
import longboard.clients.YandexResponseDto;
import longboard.clients.YandexResponseJson;
import longboard.model.Weather;
import longboard.service.YandexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ArtemParfenov on 12.07.2019.
 */

@Slf4j
@RestController
public class LongboardAdviceRestController {
    @Autowired
    private YandexService yandexService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/get-json")
    public Weather getAdvice() {
        log.debug("/get-json was called");
        return yandexService.getWeather();
    }

}
