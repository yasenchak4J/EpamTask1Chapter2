package by.yasenchak.task1.exception;

public class ParserException extends Exception {
    private static final long serialVersionUID = -2923254155579672623L;

    public ParserException(){
        super();
    }

    public ParserException(Exception exception){
        super(exception);
    }

    public ParserException(String message){
        super(message);
    }

    public ParserException(String message, Exception exception){
        super(message, exception);
    }
}
