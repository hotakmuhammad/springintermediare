package fr.dawan.springintermediare.exception;

public class IdNotFoundException extends RuntimeException {

    
    private static final long serialVersionUID = 1L;

    public IdNotFoundException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public IdNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public IdNotFoundException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public IdNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public IdNotFoundException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
    
    
}
