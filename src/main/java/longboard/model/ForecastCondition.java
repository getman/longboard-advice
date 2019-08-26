package longboard.model;

import lombok.Builder;
import lombok.Data;

/** Represents the atmosphere conditions for the forecast day: min temp, max temp, rain
 * Created by ArtemParfenov on 21.08.2019.
 */
@Data
@Builder
public class ForecastCondition {
    private short tMin;
    private short tMax;
    private RainAndCloud rainAndCloud;
}
