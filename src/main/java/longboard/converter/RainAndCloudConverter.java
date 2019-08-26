package longboard.converter;

import longboard.model.RainAndCloud;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ArtemParfenov on 21.08.2019.
 */
public final class RainAndCloudConverter {
    private static Map<String, RainAndCloud> yandexRainAndCloudTypes =
            new HashMap() {
            {
                put("cloudy", RainAndCloud.CLOUDY);
                put("cloudy-and-light-rain", RainAndCloud.CLOUDLY_AND_LIGHT_RAIN);
                put("cloudy-and-rain", RainAndCloud.CLOUDLY_AND_RAIN);
                put("partly-cloudy", RainAndCloud.PARTLY_CLOUDLY);
                put("overcast", RainAndCloud.OVERCAST);
                put("overcast-and-light-rain", RainAndCloud.OVERCAST_AND_LIGHT_RAIN);
                put("clear", RainAndCloud.CLEAR);
            }
            };

    public static RainAndCloud fromYandexRainAndCloud(String yandexRainAndCloud) {
        return yandexRainAndCloudTypes.get(yandexRainAndCloud);
    }
}
