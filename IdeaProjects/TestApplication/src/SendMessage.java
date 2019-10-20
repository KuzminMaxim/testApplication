import java.io.Serializable;

public class SendMessage implements Serializable {

    private int id;
    private String message;

    public SendMessage(){ }
    public SendMessage(String message){
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}