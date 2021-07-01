package ir.mohamadcm.restservice;

public class ErrorMessage {
    private String message;
    private Object payload;

    public ErrorMessage(String message, Object payload){
        this.message = message;
        this.payload = payload;
    }

    public Object getPayload() {
        return payload;
    }

    public String getMessage() {
        return message;
    }
}