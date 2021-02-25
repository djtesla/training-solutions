package vizsgafelkészülés03;

public enum TransactionState implements HasComplete{

    SUCCESS {
        @Override
        public boolean isComplete() {
            return true;
        }
    }, REJECTED {
        @Override
        public boolean isComplete() {
            return true;
        }
    }, PENDING {
        @Override
        public boolean isComplete() {
            return false;
        }
    };




    public static void main(String[] args) {
        SUCCESS.isComplete();

    }
}
