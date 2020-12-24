package gyakorlás;

public interface HasTransactionState {

    default boolean isCompleted() {

        return true;
    };
}
