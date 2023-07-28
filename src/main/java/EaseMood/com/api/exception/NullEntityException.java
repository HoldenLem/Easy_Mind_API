package EaseMood.com.api.exception;

public class NullEntityException extends RuntimeException{

    public NullEntityException() {
    }

    public NullEntityException(String message) {
        super(message);
    }
}
