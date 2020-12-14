package interfacedefaultmethods;

import java.time.LocalDateTime;

public class Account implements Audited, CreatedAtJanuary{

    private  LocalDateTime localDateTime;

    public Account(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return localDateTime;
    }

    @Override
    public boolean createdAfter(LocalDateTime dateTime) {
        return Audited.super.createdAfter(dateTime);
    }
}
