package longboard.clients;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

/**
 * Created by ArtemParfenov on 12.08.2019.
 */
@Data
@Builder
public class YandexResponseDto {
    private YandexResponseJson yandexResponseJson;
    /**time when weather service call was finished*/
    private Date serviceCallSuccessTime;
}
