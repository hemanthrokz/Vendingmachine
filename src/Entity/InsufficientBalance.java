package Entity;

public class InsufficientBalance extends RuntimeException {
    InsufficientBalance(String message){
        super(message);
    }
}
