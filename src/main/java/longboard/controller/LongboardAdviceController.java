package longboard.controller;

import lombok.extern.slf4j.Slf4j;
import longboard.service.YandexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ArtemParfenov on 12.07.2019.
 */

@Slf4j
@RestController
public class LongboardAdviceController {
    @Autowired
    private YandexService yandexService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/get")
    public String getAdvice() {
        log.debug("/get was called");
        return yandexService.getWeather();
    }

}
