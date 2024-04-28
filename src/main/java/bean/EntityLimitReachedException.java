package bean;

public class EntityLimitReachedException extends RuntimeException {
    public EntityLimitReachedException(String message) {
        super(message);
    }
}

