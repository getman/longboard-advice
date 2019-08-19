package longboard.controller;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import longboard.Application;
import longboard.clients.YandexClient;
import longboard.clients.YandexResponseDto;
import longboard.clients.YandexResponseJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/** Unit test
 * Created by ArtemParfenov on 13.07.2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class LongboardAdviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private YandexClient accountServiceMock;

    @Test
    public void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void shouldCorrectlyProcessYandexResponse() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        YandexResponseJson responseJson = mapper.readValue(
                new String(Files.readAllBytes(Paths.get(
                        new ClassPathResource(
                                "responses/yandex-component-response.json").getURI()
                ))), YandexResponseJson.class);
        YandexResponseDto stub = YandexResponseDto.builder()
                .serviceCallSuccessTime(new Date())
                .yandexResponseJson(responseJson)
                .build();
        when(accountServiceMock.requestYandexWeatherData()).thenReturn(stub);
        mockMvc.perform(post("/get-json")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.yandexResponseJson.now_dt").value("2019-08-13T08:49:08.376Z"))
                .andExpect(jsonPath("$.yandexResponseJson.fact.temp").value("22"))
                .andExpect(jsonPath("$.yandexResponseJson.fact.feels_like").value("23"))
                .andExpect(jsonPath("$.yandexResponseJson.forecasts[0].parts.night.temp_min").value("12"))
                .andExpect(jsonPath("$.yandexResponseJson.forecasts[0].parts.night.temp_max").value("15"))
                .andExpect(jsonPath("$.yandexResponseJson.forecasts[0].parts.day.temp_min").value("21"))
                .andExpect(jsonPath("$.yandexResponseJson.forecasts[0].parts.day.temp_max").value("23"));
    }
}
