package interfacedefaultmethods;

import java.time.LocalDateTime;

public interface CreatedAtJanuary {

    LocalDateTime getCreatedAt();

    default boolean createdAfter(LocalDateTime dateTime) {

        return getCreatedAt().isAfter(dateTime);
    }
}
