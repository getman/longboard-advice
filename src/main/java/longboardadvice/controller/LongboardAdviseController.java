package longboardadvice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by ArtemParfenov on 12.07.2019.
 */

@RestController
public class LongboardAdviseController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}