package longboard.model;

import lombok.Builder;

/** Domain object for advice to ride or not to ride today/tomorrow
 * Created by ArtemParfenov on 20.08.2019.
 */
@Builder
public class Advice {
    private String msg;
}
