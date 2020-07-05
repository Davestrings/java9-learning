package chapter3;

public class NonStringElementInCollectionException extends RuntimeException {
    public NonStringElementInCollectionException(String s, Throwable exception) {
        super(s, exception);
    }
    public NonStringElementInCollectionException(String s) {
        super(s);
    }
    public NonStringElementInCollectionException(Throwable exception) {
        super(exception);
    }
    public NonStringElementInCollectionException() {
        super();
    }

}
