package longboard.advice;

import longboard.model.Advice;
import longboard.model.Weather;

/** Generates an advice as a human readable text
 * Created by ArtemParfenov on 20.08.2019.
 */
public final class Advisor {
    public static Advice getAdvice(Weather weather) {
        return Advice.builder()
                .msg("The advice is to definitelly ride!")
                .build();
    }
}
