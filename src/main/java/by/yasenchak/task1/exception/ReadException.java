package by.yasenchak.task1.exception;

public class ReadException extends Exception {

    private static final long serialVersionUID = -3196252794671945958L;

    public ReadException(){
        super();
    }

    public ReadException(Exception exception){
        super(exception);
    }

    public ReadException(String message){
        super(message);
    }

    public ReadException(String message, Exception exception){
        super(message, exception);
    }
}
