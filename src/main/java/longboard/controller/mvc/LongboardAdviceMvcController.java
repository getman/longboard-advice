package longboard.controller.mvc;

import lombok.extern.slf4j.Slf4j;
import longboard.service.YandexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ArtemParfenov on 30.07.2019.
 */
@Slf4j
@Controller
public class LongboardAdviceMvcController {
    @Autowired
    private YandexService yandexService;

    @GetMapping("/get")
    public String getAdvice(ModelMap model) {
        log.debug("/get was called");
        model.addAttribute("weather", yandexService.getWeather());
        return "get";
    }
}
