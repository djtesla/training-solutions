package vaccinationmanager.operations;

public class InvalidMenuInputException extends  RuntimeException{

    public InvalidMenuInputException(String message) {
        super(message);
    }

    public InvalidMenuInputException() {
    }
}
