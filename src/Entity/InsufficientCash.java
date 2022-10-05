package Entity;

public class InsufficientCash extends RuntimeException {
    InsufficientCash(String message){
        super(message);
    }
}
