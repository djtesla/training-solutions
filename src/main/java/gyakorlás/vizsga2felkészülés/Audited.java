package gyakorlás.vizsga2felkészülés;

import java.time.LocalDateTime;

public interface Audited {

    LocalDateTime getCreatedAt();

    default boolean createdAfter (LocalDateTime dateTime) {
        return getCreatedAt().isAfter(dateTime);
    }
}
