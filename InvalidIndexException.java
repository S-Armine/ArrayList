public class InvalidIndexException extends IndexOutOfBoundsException{
    public InvalidIndexException() {
        super();
    }

    public InvalidIndexException(String message) {
        super(message);
    }
}
