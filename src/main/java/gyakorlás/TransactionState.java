package gyakorlás;

public enum TransactionState implements HasTransactionState{

    PENDING {
        @Override
        public boolean isCompleted() {
            return false;
        }
    },SUCCESS

    ,REJECTED {
        @Override
        public boolean isCompleted() {
            return true;
        }
    };



}
