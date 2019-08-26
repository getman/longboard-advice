package longboard.model;

import lombok.Builder;
import lombok.Data;

/** Represents the atmosphere conditions for today: fact temperature, rain
 * Created by ArtemParfenov on 20.08.2019.
 */
@Data
@Builder
public class Condition {
    private short temp;
    private short feelsLike;
    private RainAndCloud rainAndCloud;
}
